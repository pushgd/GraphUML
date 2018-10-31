package com.mygdx.UML.Application;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.UML.Debug;
import com.mygdx.UML.UML;

import UI.Button;
import UI.ButtonEventListener;

public class Menu
{

	public static final int VIEWPORT_WIDTH = (int) (UML.SCREEN_WIDTH * 0.2f);
	public static final int VIEWPORT_HEIGHT = UML.SCREEN_HEIGHT;
	ArrayList<Button> buttons = new ArrayList<Button>();

	public Menu()
	{
		Button addNodeButton = new Button(VIEWPORT_WIDTH/2,VIEWPORT_HEIGHT/4);
		addNodeButton.setID(1);
		addNodeButton.setListener(new ButtonEventListener()
			{
				
				@Override
				public void onHover(Button source)
				{
					// TODO Auto-generated method stub
					Debug.log(source+" Hover");
				}
				
				@Override
				public void onButtonPress(Button source)
				{
					// TODO Auto-generated method stub
					Debug.log(source+" Press");
				}
			});
		buttons.add(addNodeButton);
	

	}

	public void update()
	{

	}

	public void paint(SpriteBatch g)
	{
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
		Debug.log(v+" up");
		for (int i = 0; i < buttons.size(); i++)
		{
			Button b = buttons.get(i);
			Debug.log(""+b.isPointInside(v));
			if(b.isPointInside(v))
			{
				b.getListener().onButtonPress(b);
			}
		}
	}

	public void onTouchDragged(Vector2 v)
	{
		
	}

	public void onMouseMoved(Vector2 v)
	{
//		Debug.log(v+" moved");
		for (int i = 0; i < buttons.size(); i++)
		{
			Button b = buttons.get(i);
			if(b.isPointInside(v))
			{
				b.getListener().onHover(b);
			}
		}
	}

}
