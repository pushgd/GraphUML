package command;

import java.util.HashMap;

public abstract class Command
{

	protected HashMap<Object, Object>parameters;
	
	public Command()
	{
		parameters = new HashMap<Object, Object>();
	}
	public abstract void execute();

	
	public abstract void revert();
	
	public void setParameter(Object key, Object value)
	{
		parameters.put(key, value);
	}
	
	public Object getParameter(Object key)
	{
		return parameters.get(key);
	}
	
	
	
}
