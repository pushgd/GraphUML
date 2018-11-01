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

public class Canvas
{

	public static final int VIEWPORT_WIDTH = (int) (UML.SCREEN_WIDTH * 0.8f);
	public static final int VIEWPORT_HEIGHT = UML.SCREEN_HEIGHT;

	public static final int STATE_NORMAL = 0;
	public static final int STATE_ADD_TRANSITION = 1;

	private ArrayList<UMLComponent> umlComponents = new ArrayList<UMLComponent>();

	private UIComponent selected;

	private UMLComponent start, end;

	private int state = 0;

	private String helpText = "";

	private boolean noThingClicked;

	public Canvas()
	{
	}

	public void update()
	{
		Debug.log("State = "+state);
		switch (state)
			{
			case STATE_ADD_TRANSITION:
				
				if (start != null && end != null)
				{
					umlComponents.add(new Transition(start, end));
					state = STATE_NORMAL;
				}
				break;

			default:
				break;
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
				selected = uml;
			}
		}
	}

	public void onTouchUp(Vector2 v, int button)
	{
		noThingClicked =true;
		selected = null;
		UMLComponent uml = null;
		for (int i = 0; i < umlComponents.size(); i++)
		{
			uml = umlComponents.get(i);
			if (uml.isPointInside(v))
			{
				uml.onButtonPress();
				noThingClicked =false;;
				Debug.log("Pressed "+uml);
				break;
			}
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
					
					umlComponents.add(0,new Transition(start, end));
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
				State s = new State("New", 200, 200);
				umlComponents.add(s);

				break;

			case Constants.BUTTON_ADD_TRANSITION:
				helpText = "Select First Node";
				state = STATE_ADD_TRANSITION;
				start = null;
				end = null;
				break;

			default:
				break;
			}
	}

}
