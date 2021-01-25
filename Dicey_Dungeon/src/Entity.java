import java.util.ArrayList;

public abstract class Entity 
{
	protected int maxHP;
	protected int currentHP;
	protected String name;
	protected ArrayList<Die> dice;
	protected ArrayList<Skill> skills;
	
	public int getmaxHp()
	{
		return this.maxHP;
	}
	
	public int getcurrentHP()
	{
		return this.currentHP;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getSkillsSize()
	{
		return this.skills.size();
	}
	
	public int getDiceSize()
	{
		return this.dice.size();
	}
	
	public boolean isSkillUsed(int i)
	{
		return this.skills.get(i).getUsed();
	}
	
	public boolean isDieUsed(int i)
	{
		return this.dice.get(i).getUsed();
	}

	public ArrayList<String> getSkillList()
	{
		ArrayList<String> skillList=new ArrayList<String>();
		for (int i=0;i<this.skills.size();i++)
		{
			if(this.skills.get(i).getUsed()==false)
			{
				skillList.add(this.skills.get(i).getName());
				skillList.add(this.skills.get(i).toString());
			}
		}
		return skillList;
	}
	
	public ArrayList<Integer> getDiceValues()
	{
		ArrayList<Integer> diceValues=new ArrayList<Integer>();
		for (int i=0;i<this.dice.size();i++)
		{
			if(this.dice.get(i).getUsed()==false)
			{
				diceValues.add(this.dice.get(i).getValue());
			}
		}
		return diceValues;
	}
	
	public void takeDamage(int i)
	{
		this.currentHP=this.currentHP-i;
	}
	
	public void endTurn()
	{
		for (int i=0;i<this.skills.size();i++)
		{
			this.skills.get(i).reactivate();
		}
		
		for (int j=0;j<this.dice.size();j++)
		{
			this.dice.get(j).reactivate();
			this.dice.get(j).randomize();
		}
	}
}
