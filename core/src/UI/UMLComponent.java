package UI;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.UML.Debug;
import com.mygdx.UML.Application.Constants;

public abstract class UMLComponent extends UIComponent
{

	private static int baseID = 0;

	ArrayList<Transition> startingTransitions = new ArrayList<Transition>();
	ArrayList<Transition> endingTransitions = new ArrayList<Transition>();

	Color hoverColor = new Color(50 / 255f, 50 / 255f, 50 / 255f, 1);
	Color normalColor = new Color(1, 1, 1, 1);
	Color color;
	boolean hovered;

	public UMLComponent()
	{
		ID = baseID++;
		position = new Vector2();
		name = "default";
		color = normalColor;

	}

	public UMLComponent(int ID)
	{
		this.ID = ID;
		baseID = ID + 1;
		position = new Vector2();
		name = "default";
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
		String t = "<" + getClass().getSimpleName() + ">\n" + Constants.TAG_ID + ":" + ID + " \n" + Constants.TAG_NAME
				+ " : " + name + " \n" + Constants.TAG_DESCRIPTION + " : " + description + " \n"
				+ Constants.TAG_POSITION + " : " + position.x + "," + position.y + " \n" + "</"
				+ getClass().getSimpleName() + ">\n";

		return t;
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
	public void onSelect()
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
		Debug.log("On Delete " + getClass().getSimpleName());
	}

	public static UMLComponent createFromString(String s)
	{
		UMLComponent u = null;

		String attributes[] = s.split("\n");
		if (attributes[0].trim().equalsIgnoreCase("state"))
		{
			for (int i = 1; i < attributes.length; i++)
				attributes[i] = (attributes[i]).split(":")[1];

			u = new State(Integer.parseInt(attributes[Constants.ATTRIBUTE_ID].trim()));
			u.setName(attributes[Constants.ATTRIBUTE_NAME]);
			u.setDescription(attributes[Constants.ATTRIBUTE_DESCRIPTION]);
			String[] positionString = attributes[Constants.ATTRIBUTE_POSITION].split(",");
			float positionX = Float.parseFloat(positionString[0].trim());
			float positionY = Float.parseFloat(positionString[1].trim());
			u.setPosition(positionX, positionY);
			System.out.println("Created " + u);
		}
		else if (attributes[0].trim().equalsIgnoreCase("Transition"))
		{
			for (int i = 1; i < attributes.length; i++)
				attributes[i] = (attributes[i]).split(":")[1];

			u = new Transition(Integer.parseInt(attributes[Constants.ATTRIBUTE_ID].trim()),Integer.parseInt(attributes[Constants.ATTRIBUTE_START].trim()),Integer.parseInt(attributes[Constants.ATTRIBUTE_END].trim()));
			u.setName(attributes[Constants.ATTRIBUTE_NAME]);
			u.setDescription(attributes[Constants.ATTRIBUTE_DESCRIPTION]);
			String[] positionString = attributes[Constants.ATTRIBUTE_POSITION].split(",");
			float positionX = Float.parseFloat(positionString[0].trim());
			float positionY = Float.parseFloat(positionString[1].trim());
			u.setPosition(positionX, positionY);
			
			
			System.out.println("Created " + ((Transition)u).string());
		}
		return u;

	}

}
