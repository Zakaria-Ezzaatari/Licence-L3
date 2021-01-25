import java.util.ArrayList;
import java.util.Scanner;


public class CTRLBattle 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		Skill sword=new Sword();
		Skill greatAxe=new Great_Axe();
		ArrayList<Skill> sk1=new ArrayList<Skill>();
		ArrayList<Skill> sk2=new ArrayList<Skill>();
		sk1.add(sword);
		sk2.add(sword);
		sk1.add(greatAxe);
		
		Die d1=new Die();
		Die d2=new Die();
		ArrayList<Die> dice=new ArrayList<Die>();
		dice.add(d1);
		dice.add(d2);
		Player warrior=new Player("Warrior",28,sk1);
		Enemy dummy=new Enemy("Test",24,dice,sk2);
		
		int playerHP=warrior.getcurrentHP();
		int enemyHP=dummy.getcurrentHP();
		
		int maxplayerHP=warrior.getmaxHp();
		int maxenemyHP=dummy.getmaxHp();
		
		
		ArrayList<String> playerskills=warrior.getSkillList();
		ArrayList<Integer> playerdice=warrior.getDiceValues();
		
		ArrayList<String> enemyskills=dummy.getSkillList();
		ArrayList<Integer> enemydice=dummy.getDiceValues();
		
		boolean turnend=false;
		
		
		while((playerHP>0)&&(enemyHP>0))
		{
			
			while(turnend==false)
			{
				playerHP=warrior.getcurrentHP();
		        enemyHP=dummy.getcurrentHP();
				
				if ((playerHP<=0)||(enemyHP<=0))
		        {
		        	turnend=true;
		        	break;
		        }
				
				System.out.println("\n"+warrior.getName()+": "+warrior.getcurrentHP()+'/'+warrior.getmaxHp());
				System.out.println(dummy.getName()+": "+dummy.getcurrentHP()+'/'+dummy.getmaxHp());
				
				for (int i=0;i<warrior.getSkillsSize();i++)
				{
					if (warrior.isSkillUsed(i)==false)
					{
						System.out.println("Skill n° "+i+": "+playerskills.get(2*i)+":  "+playerskills.get(2*i+1));
					}
				}
				for (int j=0;j<warrior.getDiceSize();j++)
				{
					if (warrior.isDieUsed(j)==false)
					{
						System.out.println("Die n° "+j+": "+playerdice.get(j));
					}
					
				}
				System.out.print("Enter skill number or insert negative number to end turn: ");
		        int skillnum = input.nextInt();
		        if (skillnum<0)
		        {
		        	warrior.endTurn();
		        	playerskills=warrior.getSkillList();
		        	playerdice=warrior.getDiceValues();
		        }
		        else
		        { 
		        	System.out.print("Enter die number: ");
			        int dienum = input.nextInt();
			        if ((skillnum<warrior.getSkillsSize())&&(dienum<warrior.getDiceSize()&&(dienum>=0)))
			        {
			        	warrior.useSkill(skillnum, dienum, dummy);
			        }
		        }
		        
		        
		        
		        
				
				
			}
			
			
		}
		
		System.out.println("\nGame Over");
		
	}

}
