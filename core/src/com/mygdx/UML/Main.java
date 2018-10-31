package com.mygdx.UML;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.UML.Application.Canvas;
import com.mygdx.UML.Application.Menu;

public class Main implements InputProcessor
{
	private static Main instance;
	
	private  ScreenViewport canvasViewport,menuViewport;
	private Canvas canvas;
	private Menu menu;
	private Vector2 t;
	public static void init(ScreenViewport mainviewport,ScreenViewport menuViewport)
	{
		instance = new Main();
		instance.canvasViewport = mainviewport;
		instance.menuViewport = menuViewport;
		instance.t =new Vector2(); 
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

	}

	public  void paint()
	{

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
		Debug.log(screenX+" "+screenY );
		canvas.onTouchDown(canvasViewport.unproject(t),button);
		menu.onTouchDown(menuViewport.unproject(t),button);
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		t.x = screenX;
		t.y = screenY;
		canvas.onTouchUp(canvasViewport.unproject(t),button);
		menu.onTouchUp(menuViewport.unproject(t),button);
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		t.x = screenX;
		t.y = screenY;
		canvas.onTouchDragged(canvasViewport.unproject(t));
		menu.onTouchDragged(menuViewport.unproject(t));
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		t.x = screenX;
		t.y = screenY;
		canvas.onMouseMoved(canvasViewport.unproject(t));
		menu.onMouseMoved(menuViewport.unproject(t));
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
