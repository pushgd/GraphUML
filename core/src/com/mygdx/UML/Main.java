package com.mygdx.UML;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.UML.Application.Canvas;
import com.mygdx.UML.Application.Menu;

import UI.Button;

public class Main implements InputProcessor
{
	private static Main instance;

	private ScreenViewport canvasViewport, menuViewport;
	private Canvas canvas;
	private Menu menu;
	private Vector2 t;

	public static void init(ScreenViewport mainviewport, ScreenViewport menuViewport)
	{
		Button.init();
		instance = new Main();
		instance.canvasViewport = mainviewport;
		instance.menuViewport = menuViewport;
		instance.t = new Vector2();
		instance.canvas = new Canvas();
		instance.menu = new Menu();

	}

	public static Main getInstance()
	{
		return instance;
	}

	private Main()
	{

	}

	public void update()
	{
		canvas.update();
		menu.update();
	}

	public void paint(boolean isMenu, SpriteBatch g)
	{
		if (isMenu)
		{
			menu.paint(g);
		} else
		{
			canvas.paint(g);
		}
	}

	@Override
	public boolean keyDown(int keycode)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		t.x = screenX;
		t.y = screenY;
		canvas.onTouchDown(canvasViewport.unproject(t), button);
		t.x = screenX;
		t.y = screenY;
		menu.onTouchDown(menuViewport.unproject(t), button);

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		t.x = screenX;
		t.y = screenY;
		canvas.onTouchUp(canvasViewport.unproject(t), button);
		t.x = screenX;
		t.y = screenY;
		menu.onTouchUp(menuViewport.unproject(t), button);

		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
//		Debug.log("ScreenX "+screenX+" ScreenY "+screenY);
		t.x = screenX;
		t.y = screenY;
		canvas.onTouchDragged(canvasViewport.unproject(t));
		t.x = screenX;
		t.y = screenY;
		menu.onTouchDragged(menuViewport.unproject(t));
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		t.x = screenX;
		t.y = screenY;
		canvas.onMouseMoved(canvasViewport.unproject(t));
		t.x = screenX;
		t.y = screenY;
		menu.onMouseMoved(menuViewport.unproject(t));
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void onButtonPressd(int id)
	{

		menu.onButtonPressed(id);
		canvas.onButtonPressed(id);

	}

}
