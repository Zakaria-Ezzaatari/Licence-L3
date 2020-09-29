package Personne;

import java.util.*;

import util.Adresse;

public class Secretaire extends Employe 
{
	ArrayList<Manager> Managers=new ArrayList<Manager>();
	
	protected Secretaire(String leNom, String lePrenom, GregorianCalendar laDate, Adresse lAdresse,
			GregorianCalendar Embauche, float salaire) 
	{
		super(leNom, lePrenom, laDate, lAdresse, Embauche, salaire);
	}
	
	public static Secretaire createSecretaire(String leNom,String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville,GregorianCalendar Embauche,int salaire)
	{
		Secretaire secretaire;
		GregorianCalendar now=new GregorianCalendar();
		GregorianCalendar Mini=new GregorianCalendar(a+18,m,j);
		GregorianCalendar Maxi=new GregorianCalendar(a+65,m,j);

		if ((Maxi.compareTo(now)>0)&&(Mini.compareTo(Embauche) < 0))
		{
			secretaire=new Secretaire(leNom, lePrenom, new GregorianCalendar(a,m,j),new Adresse(numero,rue,code_postal,ville),Embauche,salaire);
		}
		else
		{
			secretaire=null;
		}
		return secretaire;
	}
	
	public String getManagers() 
	{
        String printmanager = "";

        if (Managers.size() > 0) 
        {
            for (int i = 0; i < this.Managers.size(); i++) 
            {
                printmanager += "Manager "+(i+1)+": " + this.Managers.get(i).getNom() + " " + this.Managers.get(i).getPrenom() + "\n";
            }
        }
        else if(this.Managers.size() >= 5)
        {
            printmanager = "Taille maximale atteinte, Utilisez la methode suppressionManager ou echangeManager;";
            System.err.println(printmanager);
        }
        else 
        {
            printmanager = "Aucun manager present, appélez la methode ajoutManager pour n'ajouter 1.";
            System.err.println(printmanager);

        }

        return printmanager;
    }
	
	public void ajoutManager(Manager BigBoss)
	{
			this.Managers.add(BigBoss);
	}

	public void suppressionManager(int index)
	{
		if ((index>=0)&&(index<5))
		{
			this.Managers.remove(index);
		}
		else
		{
			System.err.println("Taille minimale atteinte.");
		}
	}
	
	public void echangeManager(Manager BigBoss, int index) 
	{
		if((index>=0)&&(index<5))
		{
			this.Managers.set(index,BigBoss);
		}
	}
	
	public void augmenterLeSalaire(float percent)
	{
		if ((percent>=0)&&(percent<=100))
		{
			percent*=0.01;
			percent=(float) (percent+0.001*this.Managers.size());
			this.salaire=this.salaire+this.salaire*percent;
		}
		else 
		{
			System.err.println("Pourcentage non comprise entre 0 et 100");
		}
	}


	
}
