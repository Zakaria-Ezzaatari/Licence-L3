package Personne;
import java.util.*;

import util.Adresse;

public class Manager extends Employe 
{
	protected Secretaire secretary;
	protected Manager(String leNom, String lePrenom, GregorianCalendar laDate, Adresse lAdresse,
			GregorianCalendar Embauche, float salaire) 
	{
		super(leNom, lePrenom, laDate, lAdresse, Embauche, salaire);
	}
	
	public static Manager createManager(String leNom,String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville,GregorianCalendar Embauche,int salaire)
	{
		Manager manager;
		GregorianCalendar now=new GregorianCalendar();
		GregorianCalendar Mini=new GregorianCalendar(a+18,m,j);
		GregorianCalendar Maxi=new GregorianCalendar(a+65,m,j);

		if ((Maxi.compareTo(now)>0)&&(Mini.compareTo(Embauche) < 0))
		{
			manager=new Manager(leNom, lePrenom, new GregorianCalendar(a,m,j),new Adresse(numero,rue,code_postal,ville),Embauche,salaire);
		}
		else
		{
			manager=null;
		}
		return manager;
	}
	
	public void setSecretaire(Secretaire secretaire)
	{
			this.secretary=secretaire;
			secretary.ajoutManager(this);
	}
	
	/**
	* Méthode qui augmente l'attribut salaire d'une percentage donné en paramètre
	* @param percent pourcentage d'augmentation du salaire
	*/
	
	public void augmenterLeSalaire(float percent)
	{
		if ((percent>=0)&&(percent<=100))
		{
			percent*=0.01;
			int ans=super.calculAnnuite();
			percent=(float) (percent+0.005*ans);
			this.salaire=this.salaire+this.salaire*percent;
		}
		else 
		{
			System.err.println("Pourcentage non comprise entre 0 et 100");
		}
		
	}
	
	
	
	


	
	
	
}
