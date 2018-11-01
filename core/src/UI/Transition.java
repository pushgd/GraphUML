package UI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.UML.Debug;

public class Transition extends UMLComponent
{
	private UMLComponent start, end;

	public Transition(UMLComponent start, UMLComponent end)
	{
		this.start = start;
		this.end = end;
		Debug.log("Added New Transiton Between "+start +"  "+end);
		
	}

	@Override
	public void paint(SpriteBatch g)
	{

		Draw.drawLine(g, start.getPosition().x, start.getPosition().y, end.getPosition().x, end.getPosition().y, 4,0,0,0);
	}
}
