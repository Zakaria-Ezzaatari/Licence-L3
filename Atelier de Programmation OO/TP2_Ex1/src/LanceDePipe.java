
public class LanceDePipe extends LanceDe 
{
	private final int BorneInf;
	
	public LanceDePipe (int faces,int BorneInf)
	{
		super(faces);
		if ((BorneInf>=0)&&(BorneInf<120))
		{
			this.BorneInf=BorneInf;
		}
		else
		{
			this.BorneInf=0;
		}
		
	}
	
	public LanceDePipe (int faces,String name,int BorneInf)
	{
		super(faces,name);
		if ((BorneInf>=0)&&(BorneInf<120))
		{
			this.BorneInf=BorneInf;
		}
		else
		{
			this.BorneInf=0;
		}
		
	}
	
	public void setNbFaces(int num) 
	{
		if ((num>=3)&&(num<=120)&&(num>this.BorneInf)) 
		{
			this.NbFaces=num;
			System.out.println("Changement effectué");
		}
		else
		{
			System.err.println("Erreur:Valeur invalide");
		}
	}
	
	public int lancer()
	{
		int res_de=0;
		do 
		{
			res_de= r.nextInt(120)+1 ;
		}while (res_de<this.BorneInf);
		return res_de;
	}
	
	public int lancer(int nblances)
	{
		int res_de=0;
		int nb_Aleatoire=-1;
		for (int i=0;i<nblances;i++) 
		{
			do 
			{
				nb_Aleatoire= r.nextInt(120)+1 ;
			}while(nb_Aleatoire<this.BorneInf);
			
			if(nb_Aleatoire>res_de) 
			{
				res_de=nb_Aleatoire;
			}
		}
		return res_de;
	}
	
    public String toString()
    {
    	return "\nNom du Dé:"+this.name+"\nNombre de faces:"+this.NbFaces+"\nBorne inferieure"+this.BorneInf+
    			"\nNombre de dés totales:"+LanceDe.count;
    }
    
    public boolean equals(LanceDePipe De) 
    {
    	boolean equality=false;
    	if((De.name==this.name)&&(De.NbFaces==this.NbFaces)&&(De.BorneInf==this.BorneInf))
    	{
    		equality=true;
    	}
    	return equality;
    }
	

}
