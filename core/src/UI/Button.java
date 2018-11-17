package UI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Button extends UIComponent
{

	public Button()
	{
		name = "Default";
		position = new Vector2();
		color = normalColor;

	}

	public Button(float x, float y)
	{
		this();
		setPosition(x, y);
	}

	public Button(String text)
	{

	}

	@Override
	public void setPosition(float x, float y)
	{
		position.x = x;
		position.y = y;

		left = position.x - Draw.buttonBG.getWidth() / 2;
		right = position.x + Draw.buttonBG.getWidth() / 2;

		bottom = position.y - Draw.buttonBG.getHeight() / 2;
		top = position.y + Draw.buttonBG.getHeight() / 2;
	}

	public void paint(SpriteBatch g)
	{
		g.setColor(color);
		g.draw(Draw.buttonBG, position.x - Draw.buttonBG.getWidth() / 2, position.y - Draw.buttonBG.getHeight() / 2);
		Draw.fontlayout.setText(Draw.font, name);
		Draw.font.draw(g, Draw.fontlayout, position.x - Draw.fontlayout.width / 2,
				position.y + Draw.fontlayout.height / 2);
	}

	public void setID(int iD)
	{
		ID = iD;
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
	public void onUIHover()
	{
		setHover();
		listener.onHover(this);
	}

	@Override
	public void onUIHoverExit()
	{
		resetHover();
		listener.onHoverExit(this);
	}

	@Override
	public void onUIButtonPress()
	{
		listener.onClickUp(this);
	}

}
