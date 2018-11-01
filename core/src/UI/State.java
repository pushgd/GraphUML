package UI;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class State extends UMLComponent
{

	ArrayList<Transition>startingTransitions = new ArrayList<Transition>();
	ArrayList<Transition>endingTransitions = new ArrayList<Transition>();
	
	public State(String name)
	{
		super();
		text=name+ID;
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
		Draw.stateBG.setPosition(position.x-Draw.stateBG.getWidth()/2, position.y-Draw.stateBG.getHeight()/2);
		Draw.stateBG.setColor(150/255f,150/255f,150/255f,1);
		Draw.stateBG.draw(g);
		Draw.drawText(g, position.x, position.y, text);
	
	}
	
	

}
