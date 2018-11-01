package com.mygdx.UML;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class UML extends ApplicationAdapter
{
	
	public static final float MS_FOR_EACH_FRAME = 1000f / 30;
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	
	
	SpriteBatch batch;
	Texture img;
	OrthographicCamera canvasCam;
	OrthographicCamera menuCamera;

	 
	ScreenViewport canvasViewport, menuViewport;

	@Override
	public void create()
	{
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		canvasCam = new OrthographicCamera(SCREEN_WIDTH * 0.80f, SCREEN_HEIGHT);
		canvasCam.setToOrtho(false);
		canvasViewport = new ScreenViewport(canvasCam);

		menuCamera = new OrthographicCamera(SCREEN_WIDTH * 0.2f, SCREEN_HEIGHT);
		menuCamera.setToOrtho(false);
		menuViewport = new ScreenViewport(menuCamera);

		canvasViewport.update((int) (SCREEN_WIDTH * 0.8f), (int) SCREEN_HEIGHT, true);

		menuViewport.update((int) menuCamera.viewportWidth, (int) menuCamera.viewportHeight, true);
		menuViewport.setScreenX((int) canvasCam.viewportWidth);
		
		Main.init(canvasViewport,menuViewport);
		Gdx.input.setInputProcessor(Main.getInstance());

	}

	float x = 0;

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0.45f,0.45f, 0.45f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		
		// paint canvas
		canvasViewport.apply();
		batch.setProjectionMatrix(canvasCam.combined);
		batch.begin();
		Main.getInstance().paint(false,batch);
		batch.end();
		
		
		//paint menu
		menuViewport.apply();
		batch.setProjectionMatrix(menuCamera.combined);
		batch.begin();
		Main.getInstance().paint(true,batch);
//		batch.draw(img, 0, 0);
		batch.end();
//		

	}

	@Override
	public void dispose()
	{
		batch.dispose();
		img.dispose();
	}
}
