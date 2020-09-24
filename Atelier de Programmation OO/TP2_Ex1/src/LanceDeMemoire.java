
public class LanceDeMemoire extends LanceDe {

	private int LastRoll=0;
	
	public LanceDeMemoire(int faces)
	{
		super(faces);
	}
	
	public LanceDeMemoire (int faces,String name)
	{
		super(faces,name);
	}
	
	public int lancer()
	{
		int res_de;
		do
		{
			res_de= r.nextInt(120)+1 ;
		}while(res_de !=this.LastRoll);
		this.LastRoll=res_de;
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
			}while(nb_Aleatoire!=this.LastRoll);
			this.LastRoll=nb_Aleatoire;
			if(nb_Aleatoire>res_de) 
			{
				res_de=nb_Aleatoire;
			}
		}
		return res_de;
	}

}
