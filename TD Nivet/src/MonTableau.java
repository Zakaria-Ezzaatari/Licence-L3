public class MonTableau implements EstComparable
{
    private int[] tableau;
    
    public MonTableau(int[] tab)
    {
        tableau=tab.clone();
    }

    private int sommeTab(int[] tab)
    {
        int somme=0;
        for(int i=0;i<tab.length;i++)
        {
            somme+=tab[i];
        }
        return somme;
    }

    public int compareA(Object o)
    {
        if (o==null)
        {
            throw new NullPointerException("Le parametre o est null");
        }
        if (!(o instanceof MonTableau))
        {
            throw new ClassCastException("Le parametre o n'est pas un objet de type MonTableau");
        }
        else
        {
            MonTableau tab2= (MonTableau) o;

            int resultat;

            int somme1=sommeTab(this.tableau);
            int somme2=sommeTab(tab2.tableau);

            if (somme1<somme2)
            {
                resultat=-1;
            }

            else if (somme1==somme2)
            {
                resultat=0;
            }
            
            else
            {
                resultat=1;
            }
            
            return resultat;
        }
    }
}
