
public class Great_Axe extends Skill
{

	Great_Axe()
	{
		this.name="Great Axe";
		this.used=false;
	}
	
	@Override
	public String toString()
	{
		return "deal n+2 damage to the enemy";
	}

	@Override
	protected int useSkill(Die die) 
	{
		return die.getValue()+2;
	}
	
	
}
