import java.util.*;
public class Enemy extends Entity
{
	
	Enemy(String name,int maxHP,ArrayList<Die> dice,ArrayList<Skill> skills)
	{
		this.name=name;
		this.maxHP=maxHP;
		this.currentHP=maxHP;
		this.dice=new ArrayList<Die>();
		this.dice.addAll(dice);
		this.skills=new ArrayList<Skill>();
		this.skills.addAll(skills);
	}

	public void useSkill(int skill_num, int die_num,Player player) 
	{
		int res=this.skills.get(skill_num).useSkill(this.dice.get(die_num));
		player.takeDamage(res);
		this.skills.get(skill_num).deactivate();
		this.dice.get(die_num).deactivate();
	}
	
	
}
