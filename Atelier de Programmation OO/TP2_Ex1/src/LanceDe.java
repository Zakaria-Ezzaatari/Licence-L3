import java.util.*;

public class LanceDe 
{
	protected int NbFaces;
	protected final String name;
	protected static int count=0;
	protected static Random r = new Random();
	
	public LanceDe() 
	{
		this.NbFaces=6;
		count++;
		this.name=("De n°"+count);
		
	}
	
	public LanceDe(int faces)
	{
		if ((faces>=3)&&(faces<=120))
		{
			this.NbFaces=faces;
			count++;
			this.name=("De n°"+count);
		}
		else
		{
			System.err.println("Erreur:Valeur non compris entre 3 et 120");
			this.name="Error: invalid";
		}
	}
	
	public LanceDe(int faces,String name)
	{
		if ((faces>=3)&&(faces<=120))
		{
			this.NbFaces=faces;
			if ((name!="")&&(name!=null))
			{
				count++;
				this.name=name;
			}
			else 
			{
				System.err.println("Erreur Nom invalide");
				this.name="Error: invalid";

			}
		}
		else
		{
			System.err.println("Erreur:Valeur non compris entre 3 et 120");
			this.name="Error: invalid";
		}
	}
	
	public int getNbFaces() 
	{
		return this.NbFaces;
	}
	
	public static int getNbDes() 
	{
		return count;
	}
	
	public String getNomDe() 
	{
		return this.name;
	}
	
	public void setNbFaces(int num) 
	{
		if ((num>=3)&&(num<=120)) 
		{
			this.NbFaces=num;
			System.out.println("Changement effectué");
		}
		else
		{
			System.err.println("Erreur:Valeur non compris entre 3 et 120");
		}
	}
	
	public int lancer()
	{
		int res_de= r.nextInt(120)+1 ;
		return res_de;
	}
	
	public int lancer(int nblances)
	{
		int res_de=0;
		for (int i=0;i<nblances;i++) 
		{
			int nb_Aleatoire= r.nextInt(120)+1 ;
			if(nb_Aleatoire>res_de) 
			{
				res_de=nb_Aleatoire;
			}
		}
		return res_de;
	}
	
    public String toString()
    {
    	return "\nNom du Dé:"+this.name+"\nNombre de faces:"+this.NbFaces+"\nNombre de dés totales:"+LanceDe.count;
    }
    
    public boolean equals(LanceDe De) 
    {
    	boolean equality=false;
    	if((De.name==this.name)&&(De.NbFaces==this.NbFaces))
    	{
    		equality=true;
    	}
    	return equality;
    }
    
}
