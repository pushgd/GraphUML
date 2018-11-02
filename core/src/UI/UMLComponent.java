package UI;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.UML.Debug;

public abstract class UMLComponent extends UIComponent
{

	private static int baseID = 0;

	ArrayList<Transition>startingTransitions = new ArrayList<Transition>();
	ArrayList<Transition>endingTransitions = new ArrayList<Transition>();
	
	Color hoverColor = new Color(50 / 255f, 50 / 255f, 50 / 255f, 1);
	Color normalColor = new Color(1, 1, 1, 1);
	Color color;
	boolean hovered;

	public UMLComponent()
	{
		ID = baseID++;
		position = new Vector2();
		text = "default";
		color = normalColor;
	
	}

	public void setHover()
	{
		color = hoverColor;
		hovered = true;
	}

	public void resetHover()
	{
		color = normalColor;
		hovered = false;
	}

	public boolean wasHovered()
	{
		return hovered;
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return text + " " + ID;
	}

	@Override
	public void onUIHover()
	{
//		setHover();
		listener.onHover(this);
	}

	@Override
	public void onUIHoverExit()
	{
//		resetHover();
		listener.onHoverExit(this);
	}

	@Override
	public void onUIButtonPress()
	{
		listener.onClickUp(this);
	}

	@Override
	public void onUIButtonDown()
	{
		// TODO Auto-generated method stub
		listener.onClickDown(this);
	}
	
	public void addStartTransition(Transition t)
	{
		startingTransitions.add(t);
	}
	
	public void addEndTransaction(Transition t)
	{
		endingTransitions.add(t);
	}
	@Override
	public  void onSelect()
	{
		color = hoverColor;
	}
	
	@Override
	public void onDeselect()
	{
		color = normalColor;
	}
	@Override
	public void onDelete()
	{
		Debug.log("On Delete "+getClass().getSimpleName());
	}
	

}
