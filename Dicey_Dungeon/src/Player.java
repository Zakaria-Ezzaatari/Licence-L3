import java.util.ArrayList;
public class Player extends Entity
{
	private int exp;
	
	public enum NextLevel
	{
		ONE(1,2),
		TWO(2,4),
		THREE(3,7),
		FOUR(4,14),
		FIVE(5,18),
		MAX(6,0);
		
		private int currentlevel;
		private int toNextLevel;
		
		NextLevel(int level, int next)
		{
			this.currentlevel=level;
			this.toNextLevel=next;
		}
	}
	
	private NextLevel level;
	
	Player(String name,int maxHP,ArrayList<Skill> skills)
	{
		this.name=name;
		this.maxHP=maxHP;
		this.currentHP=maxHP;
		this.dice=new ArrayList<Die>();
		Die d1=new Die();
		Die d2=new Die();
		this.dice.add(d1);
		this.dice.add(d2);
		this.skills=new ArrayList<Skill>();
		this.skills.addAll(skills);
		this.exp=0;
		this.level=Player.NextLevel.ONE;
	}
	
	public int getExp()
	{
		return this.exp;
	}
	
	public int getLevel()
	{
		return this.level.currentlevel;
	}

	public void useSkill(int skill_num, int die_num,Enemy enemy) 
	{
		if((this.skills.get(skill_num).getUsed()==false)&&(this.dice.get(die_num).getUsed()==false))
		{
			int res=this.skills.get(skill_num).useSkill(this.dice.get(die_num));
			enemy.takeDamage(res);
			this.skills.get(skill_num).deactivate();
			this.dice.get(die_num).deactivate();
		}
		
	}
	
	
}