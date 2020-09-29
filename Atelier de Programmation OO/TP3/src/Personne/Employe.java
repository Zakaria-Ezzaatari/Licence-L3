package Personne;

import java.util.*;
import util.Adresse;



public class Employe extends Personne
{

	protected GregorianCalendar DateEmbauche;
	protected float salaire;
	
	/**
	 * Constructeur privé de Employe
	 * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
	 * @param Embauche la date d'embauche.
	 * @param salaire le salaire
	*/
	
	protected Employe(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse,GregorianCalendar Embauche,float salaire) 
	{
		super(leNom,lePrenom,laDate,lAdresse);
		DateEmbauche=Embauche;
		this.salaire=salaire;
	}
	
	 /** Méthode qui appelle le constructeur si la date d'embauche est valide
	 * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param j le jour de naissance
	 * @param m le mois de naissance
	 * @param a l'année de naissance
	 * @param numero le n° de la rue
	 * @param rue la rue
	 * @param code_postal le code postal de l'adresse
	 * @param ville la ville ou la personne habite
	 * @param Embauche la date d'embauche.
	 * @param salaire le salaire
	 * @return une instance de l'objet Employe
	 */
	
	public static Employe createEmploye(String leNom,String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville,GregorianCalendar Embauche,int salaire)
	{
		Employe employe;
		GregorianCalendar now=new GregorianCalendar();
		GregorianCalendar Mini=new GregorianCalendar(a+18,m,j);
		GregorianCalendar Maxi=new GregorianCalendar(a+65,m,j);

		if ((Maxi.compareTo(now)>0)&&(Mini.compareTo(Embauche) < 0))
		{
			employe=new Employe(leNom, lePrenom, new GregorianCalendar(a,m,j),new Adresse(numero,rue,code_postal,ville),Embauche,salaire);
		}
		else
		{
			employe=null;
		}
		return employe;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	
	public String toString(){
	String result="\nNom : "+nom+"\n"
	+"Prénom : "+prenom+"\n"+
	"Né(e) le : "+dateNaissance.get(Calendar.DAY_OF_MONTH)+
	"-"+dateNaissance.get(Calendar.MONTH)+
	"-"+dateNaissance.get(Calendar.YEAR)+"\n"+
	"Adresse : "+
	adresse.toString()+
	"\nEmbauché(e) le : "+DateEmbauche.get(Calendar.DAY_OF_MONTH)+
	"-"+DateEmbauche.get(Calendar.MONTH)+
	"-"+DateEmbauche.get(Calendar.YEAR)+"\n"+
	"Salaire: "+salaire+"€";
	return result;
	}
		
	/**
	* Accesseur
	* @return retourne le salaire
	*/	
		
	public float getSalaire()
	{
		return salaire;
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
			this.salaire=this.salaire+this.salaire*percent;
		}
		else 
		{
			System.err.println("Pourcentage non comprise entre 0 et 100");
		}
		
	}
	
	/**
	*Méthode qui calcule le nombres d'années qui un employé à passé en entreprise à partir de sa date d'embauche
	*@return ans années en entreprise 
	*/
	
	public int calculAnnuite()
	{
		GregorianCalendar now=new GregorianCalendar();
		int ans=now.get(GregorianCalendar.YEAR)-DateEmbauche.get(GregorianCalendar.YEAR);
		return ans;
	}
}
