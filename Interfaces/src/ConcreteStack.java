import java.util.ArrayList;

public class ConcreteStack implements AStack
{
	ArrayList<Object> Stack;
	
	ConcreteStack()
	{
		this.Stack=new ArrayList<Object>();
	}
	
	public boolean isEmpty()
	{
		boolean empty=false;
		if(this.Stack!=null)
		{
			if(this.Stack.isEmpty()) 
			{
				empty=true;
			}
		}
		return empty;		
	}
	
	public void push (Object o)
	{
		this.Stack.add(o);
	}
	
	public Object peek()
	{
		Object res=this.Stack.get(this.Stack.size() - 1);
		return res;
	}
	
	public Object pop()
	{
		Object res=peek();
		this.Stack.remove(this.Stack.size()-1);
		return res;
	}
}
