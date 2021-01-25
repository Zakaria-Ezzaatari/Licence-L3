
public abstract class Skill 
{
	protected String name;
	protected boolean used;
	
	protected String getName()
	{
		return this.name;
	}
	
	public boolean getUsed()
	{
		return this.used;
	}
	
	public void deactivate()
	{
		this.used=true;
	}
	
	public void reactivate()
	{
		this.used=false;
	}
	
	protected abstract int useSkill(Die die);
}
