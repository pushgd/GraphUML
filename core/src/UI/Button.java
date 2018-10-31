package UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Button
{
	private static BitmapFont font;
	private static GlyphLayout fontlayout;
	private static Texture bg;
	private int ID;
	private String text;
	private Vector2 position;
	private ButtonEventListener listener;
	private float left, right, top, bottom;

	public static void init()
	{
		font = new BitmapFont();
		fontlayout = new GlyphLayout();
		bg = new Texture("buttonBG.png");
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Button()
	{
		text = "Default";
		position = new Vector2();

	}

	public Button(float x, float y)
	{
		this();
		setPosition(x, y);

	}

	public Vector2 getPosition()
	{
		return position;
	}

	public void setPosition(float x, float y)
	{
		position.x = x;
		position.y = y;

		left = position.x - bg.getWidth() / 2;
		right = position.x + bg.getWidth() / 2;

		bottom = position.y - bg.getHeight() / 2;
		top = position.y + bg.getHeight() / 2;
	}

	public Button(String text)
	{

	}

	public void paint(SpriteBatch g)
	{
		g.draw(bg, position.x - bg.getWidth() / 2, position.y - bg.getHeight() / 2);
		fontlayout.setText(font, text);
		font.draw(g, fontlayout, position.x - fontlayout.width / 2, position.y + fontlayout.height / 2);
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public ButtonEventListener getListener()
	{
		return listener;
	}

	public void setListener(ButtonEventListener listener)
	{
		this.listener = listener;
	}

	public boolean isPointInside(Vector2 v)
	{
		return v.x >= left && v.x <= right && v.y >= bottom && v.y <= top;

	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return text + " " + ID;
	}

}
