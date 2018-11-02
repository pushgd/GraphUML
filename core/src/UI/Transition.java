package UI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.UML.Debug;

public class Transition extends UMLComponent
{
	private UMLComponent start, end;

	public Transition(UMLComponent start, UMLComponent end)
	{
		this.start = start;
		start.addStartTransition(this);
		this.end = end;
		end.addEndTransaction(this);;
		Debug.log("Added New Transiton Between "+start +"  "+end);
		
	}

	@Override
	public void paint(SpriteBatch g)
	{
		float ax = (start.getPosition().x + end.getPosition().x)/2;
		float ay = (start.getPosition().y + end.getPosition().y)/2;
		Draw.arrow.setOriginCenter();
		Draw.arrow.setPosition(ax+(2*Math.signum(start.getPosition().y-end.getPosition().y))-Draw.arrow.getWidth()/2,ay-(2*Math.signum(start.getPosition().x-end.getPosition().x))-Draw.arrow.getHeight()/2);
		Draw.arrow.setRotation((float) Math.toDegrees(Math.atan2(start.getPosition().y - end.getPosition().y, start.getPosition().x - end.getPosition().x)));
		Draw.arrow.draw(g);
		Draw.drawLine(g, start.getPosition().x, start.getPosition().y, end.getPosition().x, end.getPosition().y, 4,0,0,0);
	}
	@Override
	public boolean isPointInside(Vector2 v)
	{
		// TODO Auto-generated method stub
	return false;
	}
}
