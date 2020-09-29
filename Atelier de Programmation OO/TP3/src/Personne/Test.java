package Personne;
import java.util.*;


public class Test {

	public static void main(String[] args) 
	{
		Personne p1=new Personne("Zakaria","Ezzaatari",25,03,1999,5,"Z.I de Tragone","20620","Biguglia");
		Personne p1bis=new Personne("Zakaria","Ezzaatari",25,03,1999,5,"Z.I de Tragone","20620","Biguglia");
		Personne p2=new Personne("Not","Me",25,03,1998,5,"Z.I de Tragone","20620","Biguglia");
		
		System.out.println(Personne.getNbInstances());
		System.out.println(Personne.plusAgee(p2, p1bis));
		System.out.println(p2.plusAgeeQue(p1));
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p1bis));
		
		System.out.println("\n\n\n\n");
		
		GregorianCalendar test=new GregorianCalendar(2018,10,4);
		Employe employe=Employe.createEmploye("Zakaria", "Ezzaatari", 25, 03, 1999, 5, "Z.I de Tragone", "20620", "Bastia", test, 1000);
		System.out.println(employe.calculAnnuite());
		System.out.println("\n"+employe.getSalaire());
		employe.augmenterLeSalaire(10);
		System.out.println("\n"+employe.getSalaire());
		
		System.out.println("\n\n\n");
		
		GregorianCalendar newdate=new GregorianCalendar(1998,12,29);
		Manager me=Manager.createManager("Ezzaatari", "Zakaria", 25, 03, 1999, 5,
				"Z.I de Tragone", "20620", "Bastia", test, 1000);
		Manager BobRoss= Manager.createManager("Ross", "Bob", 29, 10, 1972, 1, "no", "69420", "idea", newdate , 10000);
		Secretaire secret=Secretaire.createSecretaire("Dupont", "Jeanne", 10, 7, 1977, 13, "rue", "20600", "ville", test, 5000);
		me.setSecretaire(secret);
		BobRoss.setSecretaire(secret);
		
		System.out.println(me.getSalaire());
		me.augmenterLeSalaire(10);
		System.out.println(me.getSalaire()+"\n");
		
		System.out.println(BobRoss.getSalaire());
		BobRoss.augmenterLeSalaire(10);
		System.out.println(BobRoss.getSalaire()+"\n");
		
		System.out.println(secret.getSalaire());
		secret.augmenterLeSalaire(10);
		System.out.println(secret.getSalaire()+"\n");

	}

}
