package UI;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class State extends UMLComponent
{

	public State(String name)
	{
		super();
		text = name + ID;
		normalColor = new Color(150 / 255f, 150 / 255f, 150 / 255f, 1);
		color = normalColor;
	}

	public State(String name, float x, float y)
	{
		this(name);
		setPosition(x, y);
	}

	@Override
	public void setPosition(float x, float y)
	{
		position.x = x;
		position.y = y;

		left = position.x - Draw.stateBG.getWidth() / 2;
		right = position.x + Draw.stateBG.getWidth() / 2;

		bottom = position.y - Draw.stateBG.getHeight() / 2;
		top = position.y + Draw.stateBG.getHeight() / 2;
	}

	@Override
	public void paint(SpriteBatch g)
	{
		// TODO Auto-generated method stub

		Draw.stateBG.setPosition(position.x - Draw.stateBG.getWidth() / 2, position.y - Draw.stateBG.getHeight() / 2);
		Draw.stateBG.setColor(color);
		Draw.stateBG.draw(g);
		Draw.drawText(g, position.x, position.y, text);

	}

	@Override
	public void onDelete()
	{
		for (int i = 0; i < startingTransitions.size(); i++)
		{
			startingTransitions.get(i).delete();
		}

		for (int i = 0; i < endingTransitions.size(); i++)
		{
			endingTransitions.get(i).delete();
		}

	}

}
