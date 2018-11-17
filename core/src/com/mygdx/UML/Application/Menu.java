package com.mygdx.UML.Application;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.UML.Debug;
import com.mygdx.UML.UML;

import UI.Button;
import UI.InputEventListener;
import UI.Draw;

public class Menu 
{

	public static final int VIEWPORT_WIDTH = (int) (UML.SCREEN_WIDTH * 0.2f);
	public static final int VIEWPORT_HEIGHT = UML.SCREEN_HEIGHT;
	ArrayList<Button> buttons = new ArrayList<Button>(); 

	public Menu()
	{
		int numberOfButton = 6;
		int x =numberOfButton ;
		Button addStateButton = new Button(VIEWPORT_WIDTH / 2,x* VIEWPORT_HEIGHT / (numberOfButton+1));
		addStateButton.setName("Add New State");
		addStateButton.setID(Constants.BUTTON_ADD_STATE);
		addStateButton.setListener(ButtonEventsManager.getInstance());
		buttons.add(addStateButton);
		x--;

		Button addTransitionButton = new Button(VIEWPORT_WIDTH / 2,x* VIEWPORT_HEIGHT / (numberOfButton+1));
		addTransitionButton.setName("Add New Transion");
		addTransitionButton.setID(Constants.BUTTON_ADD_TRANSITION);
		addTransitionButton.setListener(ButtonEventsManager.getInstance());
		buttons.add(addTransitionButton);
		x--;
		Button delete = new Button(VIEWPORT_WIDTH / 2,x* VIEWPORT_HEIGHT / (numberOfButton+1));
		delete.setName("Delete");
		delete.setID(Constants.BUTTON_DELETE);
		delete.setListener(ButtonEventsManager.getInstance());
		buttons.add(delete);
		x--;
		Button travel = new Button(VIEWPORT_WIDTH / 2,x* VIEWPORT_HEIGHT / (numberOfButton+1));
		travel.setName("travel");
		travel.setID(Constants.BUTTON_TRAVEL);
		travel.setListener(ButtonEventsManager.getInstance());
		buttons.add(travel);
		x--;
		Button save = new Button(VIEWPORT_WIDTH / 2,x* VIEWPORT_HEIGHT / (numberOfButton+1));
		save.setName("Save");
		save.setID(Constants.BUTTON_SAVE);
		save.setListener(ButtonEventsManager.getInstance());
		buttons.add(save);
		x--;
		
		
		Button load = new Button(VIEWPORT_WIDTH / 2,x* VIEWPORT_HEIGHT / (numberOfButton+1));
		load.setName("Load");
		load.setID(Constants.BUTTON_LOAD);
		load.setListener(ButtonEventsManager.getInstance());
		buttons.add(load);
		x--;
		
		
		
		
	}

	public void update()
	{

	}

	public void paint(SpriteBatch g)
	{
//		Debug.log(" "+buttons.size());
		Draw.drawRect(g, 0, 0, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,200,200,200,255);
		for (int i = 0; i < buttons.size(); i++)
		{
			Button b = buttons.get(i);
			b.paint(g);
		}
	}

	public void onTouchDown(Vector2 v, int button)
	{

	}

	public void onTouchUp(Vector2 v, int button)
	{

		for (int i = 0; i < buttons.size(); i++)
		{
			Button b = buttons.get(i);
			if (b.isPointInside(v))
			{
				b.onButtonPress();
			}

		}
	}

	public void onTouchDragged(Vector2 v)
	{

	}

	public void onMouseMoved(Vector2 v)
	{

		for (int i = 0; i < buttons.size(); i++)
		{
			Button b = buttons.get(i);
			if (b.isPointInside(v))
			{
				b.onHover();
			} else if (b.wasHovered())
			{
				b.onHoverExit();
			}
		}
	}
	
	public void onButtonPressed(int id)
	{
		
	}
	
	
	

}
