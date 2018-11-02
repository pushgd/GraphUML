package UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.UML.Debug;

public class UIComponent
{
	private boolean delete;

	protected int ID;
	protected String text;
	protected String description;
	
	protected Vector2 position;
	protected InputEventListener listener;
	protected float left, right, top, bottom;

	protected Color hoverColor = new Color(50 / 255f, 50 / 255f, 50 / 255f, 1);
	protected Color normalColor = new Color(150 / 255f, 150 / 255f, 150 / 255f, 1);
	protected Color color;
	protected boolean hovered;

	public UIComponent()
	{
		listener = dummylistener;
		position = new Vector2();
	}

	public InputEventListener getListener()
	{
		return listener;
	}

	public void setListener(InputEventListener listener)
	{
		this.listener = listener;
	}

	public boolean isPointInside(Vector2 v)
	{
		return v.x >= left && v.x <= right && v.y >= bottom && v.y <= top;

	}

	public Color getHoverColor()
	{
		return hoverColor;
	}

	public void setHoverColor(Color hoverColor)
	{
		this.hoverColor = hoverColor;
	}

	public static void init()
	{

	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public int getID()
	{
		return ID;
	}

	public final void onHover()
	{

		onUIHover();
	}

	public final void onHoverExit()
	{

		onUIHoverExit();
	}

	public final void onButtonPress()
	{
		onUIButtonPress();
	}

	public final void onButtonDown()
	{
		onUIButtonDown();
	}

	public final void onDrag()
	{
		onUIDragged();
	}

	protected void onUIHover()
	{

	}

	protected void onUIHoverExit()
	{

	}

	protected void onUIButtonPress()
	{

	}

	protected void onUIButtonDown()
	{

	}

	protected void onUIDragged()
	{

	}

	public Vector2 getPosition()
	{
		return position;
	}

	public void setPosition(float x, float y)
	{
		position.x = x;
		position.y = y;

		left = position.x - Draw.buttonBG.getWidth() / 2;
		right = position.x + Draw.buttonBG.getWidth() / 2;

		bottom = position.y - Draw.buttonBG.getHeight() / 2;
		top = position.y + Draw.buttonBG.getHeight() / 2;
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return text + " " + ID;
	}

	public void paint(SpriteBatch g)
	{
		Debug.log("Not Implemented");
	}

	private InputEventListener dummylistener = new InputEventListener()
		{

			@Override
			public void onHoverExit(UIComponent source)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void onHover(UIComponent source)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void onDrag(UIComponent source)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void onClickUp(UIComponent source)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void onClickDown(UIComponent source)
			{
				// TODO Auto-generated method stub

			}
		};

	public void delete()
	{
		onDelete();
		delete = true;
	}

	public void onSelect()
	{

	}

	public void onDeselect()
	{

	}

	public void onDelete()
	{

	}

	public boolean toBeDeleted()
	{
		return delete;
	}
	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}


}
