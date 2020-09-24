
public class TestDe {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		LanceDe De1=new LanceDe();
		System.out.println(De1.toString());
		LanceDe De2=new LanceDe(6);
		System.out.println(De2.toString());
		LanceDe De3=new LanceDe(12,"True Dice");
		System.out.println(De3.toString());
		LanceDe De4=new LanceDe(12,"True Dice");
		System.out.println(De4.toString());
		
		if (De3.equals(De4)) 
		{
			System.out.println("Equals\n");
		}
		
		System.out.println(De3.lancer());
		System.out.println(De2.lancer(11));
		
		LanceDePipe PDe1=new LanceDePipe(100,25);
		LanceDePipe PDe2=new LanceDePipe(120,"Dé Pipé",118);
		System.out.println(PDe2.lancer());
		System.out.println(PDe1.lancer(12));
		
		LanceDeMemoire Mde1=new LanceDeMemoire(100,"name");
		System.out.println(Mde1.toString());
		

	}

}
