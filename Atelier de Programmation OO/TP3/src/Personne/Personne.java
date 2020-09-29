package Personne;

import java.util.*;
import util.Adresse;


public class Personne{
    protected static int NbInstances=0;
	protected static final Adresse ADRESSE_INCONNUE = null;
    protected String nom;
    protected String prenom;
    protected final GregorianCalendar dateNaissance;
    protected Adresse adresse=ADRESSE_INCONNUE;
	
	/**
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
	 */
	public Personne(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse){
		nom = leNom.toUpperCase();
		prenom=lePrenom;
		dateNaissance=laDate;
		adresse=lAdresse;
		NbInstances++;
	}
	
	/** 
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param j le jour de naissance
	 * @param m le mois de naissance
	 * @param a l'année de naissance
	 * @param numero le n° de la rue
	 * @param rue la rue
	 * @param code_postal le code postal de l'adresse
	 * @param ville la ville ou la personne habite
	 */
	public Personne(String leNom,String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville){
		this(leNom, lePrenom, new GregorianCalendar(a,m,j),new Adresse(numero,rue,code_postal,ville));
	}

	/**
	 * Accesseur
	 * @return retourne le nom
	 */
	public String getNom(){
		return nom;
	}
	/**
	 * Accesseur
	 * @return retourne le prénom
	 */
	public String getPrenom(){
		return prenom;
	}
	/**
	 * Accesseur
	 * @return retourne la date de naissance	 
	 */
	public GregorianCalendar getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * Accesseur
	 * @return retourne l'adresse	 
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	/**
	 * Accesseur
	 * @return retourne le nombre d'instances
	 */
	public static int getNbInstances()
	{
		return NbInstances;
	}
	/**
	 * Modificateur
	 * @param retourne l'adresse	 
	 */
	public void setAdresse(Adresse a) {
		adresse=a;
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
		adresse.toString();
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals()
	 */ 
		@Override
	 public boolean equals(Object obj)
	 { 
		boolean equality=false; 
		if (obj instanceof Personne)
		 {
			 Personne p2=(Personne) obj;
			 if(p2.getNom().equals(this.getNom())&&p2.getPrenom().equals(this.getPrenom())&&p2.getDateNaissance().compareTo(this.getDateNaissance())==0)
			 {
				 equality=true;
			 }
		 }
		 return equality;
	 }
	 /** Comparer les dates de naissance de 2 Personnes pour voir qui est plus agée.
	 * @param p1 Prémiere personne
	 * @param p2 Deuxiéme personne
	 * @return returne un bool qui verifie si p1 est plus agée que p2
	 */
	public static boolean plusAgee(Personne p1,Personne p2)
	{
		return(p1.dateNaissance.compareTo(p2.dateNaissance)<0);
	}
	/** 
	 * Comparer les dates de naissance de l'instance courante avec une autre Personne pour voir qui est plus agée.
	 * @param p2 Deuxiéme personne
	 * @return returne un bool qui verifie si l'instance courante est plus agée que p2
	 */
	public boolean plusAgeeQue(Personne p2)
	{
		return(this.dateNaissance.compareTo(p2.dateNaissance)<0);
	}
}

    
   
   