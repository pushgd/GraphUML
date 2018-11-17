package com.mygdx.UML.Application;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.UML.Debug;
import com.mygdx.UML.Main;
import com.mygdx.UML.UML;

import UI.Button;
import UI.Draw;
import UI.State;
import UI.Transition;
import UI.UIComponent;
import UI.UMLComponent;
import command.AddStateCommand;
import command.Command;

public class Canvas
{

	public static final int VIEWPORT_WIDTH = (int) (UML.SCREEN_WIDTH * 0.8f);
	public static final int VIEWPORT_HEIGHT = UML.SCREEN_HEIGHT;

	public static final int STATE_NORMAL = 0;
	public static final int STATE_ADD_TRANSITION = 1;

	private ArrayList<UMLComponent> umlComponents = new ArrayList<UMLComponent>();
	private ArrayList<State> states = new ArrayList<State>();

	private UMLComponent selected;

	private UMLComponent start, end;

	private int state = 0;

	private String helpText = "";

	private boolean noThingClicked;

	public Canvas()
	{
//		umlComponents.add(UMLComponent.createFromString("ID:0 \n Name : From String \n Description : null \n Position : 556.0,550.0 "));
	}

	public void update()
	{

		for(int i =0;i<umlComponents.size();i++)
		{
			UMLComponent u = umlComponents.get(i);
			if(u.toBeDeleted())
			{
				umlComponents.remove(u);
				if(u instanceof State)
				{
					states.remove(u);
				}
				i--;
			}
		}
		
		
	}

	public void paint(SpriteBatch g)
	{
		

		Draw.drawRect(g, 0, 0, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, 180, 180, 180, 255);

		for (int i = 0; i < umlComponents.size(); i++)
		{
			UMLComponent uml = umlComponents.get(i);
			uml.paint(g);
		}

		Draw.drawText(g, VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT * 0.98f, helpText);
	}

	public void onTouchDown(Vector2 v, int button)
	{
		noThingClicked = true;
		for (int i = 0; i < umlComponents.size(); i++)
		{
			UMLComponent uml = umlComponents.get(i);
			if (uml.isPointInside(v))
			{
				noThingClicked = false;
				uml.onButtonDown();
				if(selected!= null)
				{
					selected.onDeselect();
				}
				selected = uml;
				selected.onSelect();
				break;
			}
		}
	}

	public void onTouchUp(Vector2 v, int button)
	{
		noThingClicked = true;

		UMLComponent uml = null;
		for (int i = 0; i < umlComponents.size(); i++)
		{
			uml = umlComponents.get(i);
			if (uml.isPointInside(v))
			{
				uml.onButtonPress();
				noThingClicked = false;
				Debug.log("Pressed " + uml);
				break;
			}
		}
		if (button == 1)
		{
			selected.onDeselect();
			selected = null;
		}

		switch (state)
			{
			case STATE_ADD_TRANSITION:
				if (noThingClicked)
				{
					state = STATE_NORMAL;
					helpText = "";
					break;
				}
				if (start == null)
				{
					start = uml;
					helpText = "Select Second Node";

				} else
				{
					end = uml;

					umlComponents.add(0, new Transition(start, end));
					helpText = "";
					state = STATE_NORMAL;
				}
				break;

			default:
				break;
			}

	}

	public void onTouchDragged(Vector2 v)
	{
		if (selected != null)
			selected.setPosition(v.x, v.y);
		for (int i = 0; i < umlComponents.size(); i++)
		{
			UMLComponent uml = umlComponents.get(i);
			if (uml.isPointInside(v))
			{
				uml.onDrag();
				break;
			}
		}
	}

	public void onMouseMoved(Vector2 v)
	{
		for (int i = 0; i < umlComponents.size(); i++)
		{
			UMLComponent u = umlComponents.get(i);
			if (u.isPointInside(v))
			{
				u.onHover();
			} else if (u.wasHovered())
			{
				u.onHoverExit();
			}
		}
	}

	public void onButtonPressed(int id)
	{
		Debug.log("ButtonPressed Canvas " + id);
		switch (id)
			{
			case Constants.BUTTON_ADD_STATE:
//				State s = new State("New", 200, 200);
//				umlComponents.add(s);
				AddStateCommand c = new AddStateCommand();
				c.setParameter(AddStateCommand.STATE_POSITION, new Vector2(200, 200));
				c.setParameter(AddStateCommand.STATE_NAME, "New");
				c.setParameter(AddStateCommand.CANVAS, this);
				c.execute();
				break;

			case Constants.BUTTON_ADD_TRANSITION:
				helpText = "Select First Node";
				state = STATE_ADD_TRANSITION;
				start = null;
				end = null;
				break;

			case Constants.BUTTON_DELETE:
				selected.delete();
				selected= null;
				break;
				
			case Constants.BUTTON_SAVE:
				save();
				break;
				
			case Constants.BUTTON_LOAD:
				load();
				break;

			default:
				break;
			}
	}

	public void addState(State s)
	{
		umlComponents.add(s);
		states.add(s);
	}

	public void addTransition(Transition t)
	{
		umlComponents.add(t);
	}
	
	public void save()
	{
		FileReaderWriter.saveFile(umlComponents);
	}
	
	public void load()
	{
		umlComponents.removeAll(umlComponents);
	ArrayList<String> components = FileReaderWriter.load();
	for(int i =0;i<components.size();i++)
	{
		umlComponents.add(UMLComponent.createFromString(components.get(i)));
	}
		
	for(UMLComponent u : umlComponents)
	{
		u.onLoadComplete();
	}
	}
	
	public UMLComponent getComponent(int ID)
	{
		
		
		for(UMLComponent u :umlComponents)
		{
			if(u.getID()== ID)
			{
				return u;
			}
		}
		
		return null;
	}
	
}
