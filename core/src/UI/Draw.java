package UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Draw
{
	public static Texture p = new Texture("pixel.png");
	public static Sprite pixel = new Sprite(p);

	public static BitmapFont font = new BitmapFont();
	public static GlyphLayout fontlayout = new GlyphLayout();
	public static Sprite buttonBG = new Sprite(new Texture("buttonBG.png"));
	public static Sprite stateBG = new Sprite(new Texture("stateBG.png"));
	public static Sprite arrow = new Sprite(new Texture("arrow.png"));

	public static void drawRect(SpriteBatch g, float x, float y, float width, float height)
	{
		pixel.setOrigin(0, 0);
		pixel.setScale(width, height);
		pixel.setPosition(x, y);
		pixel.draw(g);
		pixel.setScale(1, 1);

	}

	public static void drawRect(SpriteBatch g, float x, float y, float width, float height, Color c)
	{
		pixel.setColor(c);
		drawRect(g, x, y, width, height);
		pixel.setColor(Color.WHITE);
	}

	public static void drawRect(SpriteBatch s, float x, float y, float width, float height, int r, int g, int b, int a)
	{
		pixel.setColor(r / 255f, g / 255f, b / 255f, a / 255f);
		drawRect(s, x, y, width, height);
		pixel.setColor(Color.WHITE);
	}

	public static void drawText(SpriteBatch g, float x, float y, String text)
	{
		fontlayout.setText(font, text);
		font.draw(g, fontlayout, x - fontlayout.width / 2, y + fontlayout.height / 2);
	}

	
	
	
	public static void drawLine(SpriteBatch spritebatch, float x1, float y1, float x2, float y2, int height)
	{
		float angle = ((float) Math.toDegrees(Math.atan2((y1 - y2), (x1 - x2)))) - 180;
		float length = (float) Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));

		pixel.setSize(length, height);
		pixel.setOrigin(0, 0);
		pixel.setRotation(angle);
		pixel.setPosition(x1, y1);
		pixel.draw(spritebatch);
		pixel.setColor(Color.WHITE);
		pixel.setRotation(0);
	}
	
	public static void drawLine(SpriteBatch spritebatch, float x1, float y1, float x2, float y2, int height,float r,float g,float b)
	{
		
		pixel.setColor(r/255, g/255, b/255,1);
		drawLine(spritebatch, x1, y1, x2, y2, height);
	
		
	}

}
