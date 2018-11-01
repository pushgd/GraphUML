package com.mygdx.UML.Application;

import com.mygdx.UML.Main;

import UI.Button;
import UI.InputEventListener;
import UI.UIComponent;

public class ButtonEventsManager implements InputEventListener
{
	private static ButtonEventsManager instance;

	public static ButtonEventsManager getInstance()
	{
		if(instance == null)
			instance = new ButtonEventsManager();
		return instance;
	}

	@Override
	public void onClickUp(UIComponent source)
	{

		switch (source.getID())
			{
			case Constants.BUTTON_ADD_STATE:
				Main.getInstance().onButtonPressd(source.getID());
				break;
				
			case Constants.BUTTON_ADD_TRANSITION:
				Main.getInstance().onButtonPressd(source.getID());
				break;

			default:
				break;
			}

	}

	@Override
	public void onHover(UIComponent source)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onHoverExit(UIComponent source)
	{
		// TODO Auto-generated method stub

	}

	private ButtonEventsManager()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClickDown(UIComponent source)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDrag(UIComponent source)
	{
		// TODO Auto-generated method stub
		
	}

}
