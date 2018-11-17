package UI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.UML.Debug;
import com.mygdx.UML.Main;
import com.mygdx.UML.Application.Canvas;
import com.mygdx.UML.Application.Constants;

public class Transition extends UMLComponent
{
	private UMLComponent start, end;
	private int startID,endID;
	public UMLComponent getStart()
	{
		return start;
	}

	public void setStart(UMLComponent start)
	{
		this.start = start;
	}

	public UMLComponent getEnd()
	{
		return end;
	}

	public void setEnd(UMLComponent end)
	{
		this.end = end;
	}

	public Transition(UMLComponent start, UMLComponent end)
	{
		this.start = start;
		start.addStartTransition(this);
		this.end = end;
		end.addEndTransaction(this);;
		Debug.log("Added New Transiton Between "+start +"  "+end);
		
	}

	public Transition(int ID,int start , int end)
	{
		super(ID);
		startID = start;
		endID = end;
		
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
	
	@Override
	public String toString()
	{
		String t = "<"+getClass().getSimpleName()+">\n"
				+Constants.TAG_ID+":"+ID+" \n"	
				+Constants.TAG_NAME+" : "+name+" \n"
				+Constants.TAG_DESCRIPTION+" : "+description+" \n"
				+Constants.TAG_POSITION+" : "+position.x+ ","+position.y+" \n"
				+Constants.TAG_START+" : "+start.ID+" \n"
				+Constants.TAG_END+" : "+end.ID+" \n"
				+"</"+getClass().getSimpleName()+">\n"
				;
		return t;
	}
	
	public String string()
	{
		String t = "<"+getClass().getSimpleName()+">\n"
				+Constants.TAG_ID+":"+ID+" \n"	
				+Constants.TAG_NAME+" : "+name+" \n"
				+Constants.TAG_DESCRIPTION+" : "+description+" \n"
				+Constants.TAG_POSITION+" : "+position.x+ ","+position.y+" \n"
				/*+Constants.TAG_START+" : "+start.ID+" \n"
				+Constants.TAG_END+" : "+end.ID+" \n"*/
				+"</"+getClass().getSimpleName()+">\n"
				;
		return t;
	}
	@Override
	public void onLoadComplete()
	{
		// TODO Auto-generated method stub
		super.onLoadComplete();
		start = Main.getInstance().getComponent(startID);
		start.startingTransitions.add(this);
		
		end = Main.getInstance().getComponent(endID);
		end.endingTransitions.add(this);
				
		
	}
}
