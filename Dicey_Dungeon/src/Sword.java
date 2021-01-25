
public class Sword extends Skill 
{
	
	
	Sword()
	{
		this.name="Sword";
		this.used=false;
	}
	
	@Override
	public String toString()
	{
		return "deal n damage to the enemy";
	}

	@Override
	protected int useSkill(Die die) 
	{
		return die.getValue();
	}
	
	
}
