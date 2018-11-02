package command;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.UML.Application.Canvas;

import UI.State;

public class AddStateCommand extends Command
{
	
	public static final Integer STATE_NAME = new Integer(1);
	public static final Integer STATE_POSITION = new Integer(2);
	public static final Integer CANVAS= new Integer(3);
	public static final Integer STATE = new Integer(4);

	@Override
	public void execute()
	{
	Vector2 p = (Vector2) parameters.get(STATE_POSITION);
	String name = (String) parameters.get(STATE_NAME);
	Canvas c = (Canvas) parameters.get(CANVAS);
	c.addState(new State(name,p.x,p.y));
	
		
	}

	@Override
	public void revert()
	{
		// TODO Auto-generated method stub
		
	}

}
