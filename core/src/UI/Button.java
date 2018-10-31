package UI;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Button
{
	public static BitmapFont font;
	private int ID;
	private String Text;
	private Vector2 position;
	public Button()
	{
		Text="Default";
		position = new Vector2();
	}
	
	public Button(int in )
	{
		Text="Default";
		position = new Vector2();
	}
	
	public Button(String text)
	{
		
	}
	
	public void paint(SpriteBatch g)
	{
	
	}

}
