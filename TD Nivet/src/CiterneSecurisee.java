import java.time.LocalDate;

public class CiterneSecurisee extends Citerne implements Cloneable
{
    private Citerne TropPlein=null;

    CiterneSecurisee(int cap, Liquide cont,Citerne tpPlein) throws IllegalCapacityException
    {
        super(cap, cont);
        if ((tpPlein!=null)&&(tpPlein.contenu.equals(this.contenu))&&
        (tpPlein instanceof Citerne)&& !(tpPlein instanceof CiterneSecurisee))
        {
            TropPlein=tpPlein;
        }
        else
        {
            System.err.println("Paramétre TropPlein invalide, utilisation des valeurs par default");
            TropPlein=new Citerne((int) (this.capacite*0.1), this.contenu);
        }
    }

    CiterneSecurisee(int cap, Liquide cont) throws IllegalCapacityException
    {
        super(cap, cont);
        System.err.println("Paramétre TropPlein inexistant, utilisation des valeurs par default");
        TropPlein=new Citerne((int) (this.capacite*0.1), this.contenu);
    }

    private CiterneSecurisee(int cap, Liquide cont, LocalDate clonedate, Citerne tpPlein)
    {
        super(cap, cont,clonedate);
        TropPlein=tpPlein;
        
    }

    @Override
    public void nettoyer()
    {
        super.nettoyer();
        TropPlein.nettoyer();
    }

    public void nettoyerTropPlein()
    {
        TropPlein.volume=0;
        TropPlein.contenu=this.contenu;
    }

    @Override
    public void setLiquide(Liquide liq) throws IsNotCleanException
    {
        super.setLiquide(liq);
        TropPlein.setLiquide(liq);
    }

    @Override
    public void ajouterLiquide(int quantite) throws NoLiquidTypeException,MaximumLiquidCapacityExceededException
    {
        if (this.contenu==null)
        {
            throw new NoLiquidTypeException("Impossible ajouter liquides avant de definir le type de liquide de la citerne");
        }
        if (quantite<CAP_MIN )
        {
            throw new IllegalArgumentException("Quantité <CAP_MIN ");
        }
        double volTot=this.volume+quantite;
        if (volTot<=this.capacite)
        {
            this.volume+=quantite;
        }
        else if (this.volume+quantite<=this.capacite+TropPlein.capacite)
        {
            System.err.println("Debordement de la capacité maximale de la cuve principale,debordement en TropPlein");
            this.volume=this.capacite;
            double volRestant=volTot-this.capacite;
            if(volRestant+TropPlein.volume<=TropPlein.capacite)
            {
                if((volRestant+TropPlein.volume)>(TropPlein.capacite/2))
                {
                    System.err.println("Volume TropPlein a dépassé le 50% de la capacité maximale. Un nettoyage est reccomandé");
                }
                TropPlein.ajouterLiquide((int) volRestant);
            }
            else
            {
                TropPlein.volume=TropPlein.capacite;
                throw new MaximumLiquidCapacityExceededException();
            }
        }
        else
        {
            this.volume=this.capacite;
            TropPlein.volume=TropPlein.capacite;
            throw new MaximumLiquidCapacityExceededException();
        }
    
    }

    @Override
    public void ajouterLiquidePourcent(double quantite) throws NoLiquidTypeException,MaximumLiquidCapacityExceededException
    {
        if (this.contenu==null || TropPlein.contenu==null)
        {
            throw new NoLiquidTypeException("Impossible ajouter liquides avant de definir le type de liquide de la citerne");
        }
        if (quantite<=0 || quantite>1)
        {
            throw new IllegalArgumentException("Quantité <=0 ou >1");
        }

        double ajout= (this.capacite*quantite);

        if (this.volume+ajout<=this.capacite)
        {
            this.volume+=ajout;
        }
        else if (this.volume+ajout<=this.capacite+TropPlein.capacite)
        {
            this.volume=this.capacite;
            System.err.println("Debordement de la capacité maximale de la cuve principale,debordement en TropPlein");
            double volRestant=ajout-this.capacite;
            if(volRestant+TropPlein.volume<=TropPlein.capacite)
            {
                if((volRestant+TropPlein.volume)>(TropPlein.capacite/2))
                {
                    System.err.println("Volume TropPlein a dépassé le 50% de la capacité maximale. Un nettoyage est reccomandé");
                }
                TropPlein.ajouterLiquide((int) volRestant);
            }
            else
            {
                TropPlein.volume=TropPlein.capacite;
                throw new MaximumLiquidCapacityExceededException();
            }
        }
        else
        {
            this.volume=this.capacite;
            TropPlein.volume=TropPlein.capacite;
            throw new MaximumLiquidCapacityExceededException();
        }
    }

    @Override
    public int compareA(Object o)
    {
        if (o==null)
        {
            throw new NullPointerException("Le parametre o est null");
        }
        if (!(o instanceof CiterneSecurisee))
        {
            throw new ClassCastException("Le parametre o n'est pas un objet de type CiterneSecurisee");
        }
        CiterneSecurisee c2=(CiterneSecurisee) o;
        int result;
        if(this.volume+TropPlein.volume<c2.volume+c2.TropPlein.volume)
        {
            result=-1;
        }
        else if(this.volume+TropPlein.volume>c2.volume+c2.TropPlein.volume)
        {
            result=1;
        }
        else
        {
            if(this.capacite+TropPlein.capacite<c2.capacite+c2.TropPlein.capacite)
            {
                result=-1;
            }
            if(this.capacite+TropPlein.capacite>c2.capacite+c2.TropPlein.capacite)
            {
                result=1;
            }
            else
            {
                result=0;
            }
        }
        return result;
    }
    
    @Override
    public boolean equals(Object o)
    {
        
        if (o==null)
        {
            throw new NullPointerException("Le parametre o est null");
        }
        if (!(o instanceof CiterneSecurisee))
        {
            throw new ClassCastException("Le parametre o n'est pas un objet de type CiterneSecurisee");
        }
        boolean result=false;
        CiterneSecurisee c2= (CiterneSecurisee) o;
        result=super.equals(c2) && TropPlein.equals(c2.TropPlein);
        return result;
    }

    @Override
    public Object clone()
    {
        return new CiterneSecurisee(this.capacite, this.contenu,this.dateCreation,TropPlein);
    }

    @Override
    public String toString() 
    {
        return super.toString() + ", Citerne TropPlein : " + TropPlein.toString();
    }

}
