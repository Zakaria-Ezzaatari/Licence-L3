import java.util.*;

public class Die 
{
	private int value;
	private boolean used;
	
	Die()
	{
		this.randomize();
		this.used=false;
	}
	
	public boolean getUsed()
	{
		return this.used;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public void randomize()
	{
		Random rand=new Random();
		this.value=rand.nextInt(6)+1;
	}
	
	public void deactivate()
	{
		this.used=true;
	}
	
	public void reactivate()
	{
		this.used=false;
	}
	
}
