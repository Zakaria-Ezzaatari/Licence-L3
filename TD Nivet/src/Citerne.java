

import java.time.LocalDate;

public class Citerne implements EstComparable
{
    public static final int CAP_MAX=20000;
    public static final int CAP_MIN=0;

    public final int id;
    public final int capacite;
    protected final LocalDate dateCreation;

    private static int nbCiternes = 0;

    protected double volume = 0;

    public enum Liquide
    {
        EAU("Eau",10),
        VIN("Vin",15),
        HUILE("Huile",9);

        private String type;
        private int temperature;

        Liquide(String type, int temp)
        {
            this.type=type;
            this.temperature=temp;
        }
    }

    protected Liquide contenu;

    Citerne(int cap,Liquide cont) throws IllegalCapacityException
    {
        
        if(cap<CAP_MIN || cap>CAP_MAX)
        {
            throw new IllegalCapacityException("Capacité>20000 m3 ou <=0 m3");
        }
        if (cont==null)
        {
            throw new NullPointerException("L'objet Liquide contenu est null");
        }
        this.capacite=cap;
        this.contenu=cont;
        this.dateCreation=LocalDate.now();
        nbCiternes++;
        this.id=nbCiternes;
        
    }

    protected Citerne(int cap,Liquide cont,LocalDate clonedate)
    {
        this.capacite=cap;
        this.contenu=cont;
        this.dateCreation=clonedate;
        nbCiternes++;
        this.id=nbCiternes;
        
    }

    static Citerne plusAncienne(Citerne c1,Citerne c2)
    {
        Citerne resultat=null;
        if (c1.dateCreation.isBefore(c2.dateCreation))
        {
            resultat=c1;
        }
        else
        {
            resultat=c2;
        }
        return resultat;
    }

    public String getTypeLiquide()
    {
        if (contenu==null)
        {
            return "null";
        }
        return contenu.type;
    }

    public double getQuantiteLiquide()
    {
        return volume;
    }

    public LocalDate getDateCreation()
    {
        return dateCreation;
    }

    public static int getNbCiternes()
    {
        return nbCiternes;
    }

    public void setLiquide(Liquide liq) throws IsNotCleanException
    {
        if((this.contenu==null) &&(volume==0))
        {
            this.contenu=liq;
        }
        else
        {
            throw new IsNotCleanException("La citerne n'a pas été nettoyée");
        }
    }

    public void ajouterLiquide(int quantite) throws NoLiquidTypeException,MaximumLiquidCapacityExceededException
    {
        if (this.contenu==null)
        {
            throw new NoLiquidTypeException("Impossible ajouter liquides avant de definir le type de liquide de la citerne");
        }
        if (quantite<CAP_MIN || quantite>this.capacite)
        {
            throw new IllegalArgumentException("Quantité <CAP_MIN ou >capacité maximale");
        }
        if (this.volume+quantite>this.capacite)
        {
            this.volume=this.capacite;
            throw new MaximumLiquidCapacityExceededException();
        }
        else
        {
            this.volume+=quantite;
        }
    }

    public void ajouterLiquidePourcent(double quantite) throws NoLiquidTypeException,MaximumLiquidCapacityExceededException
    {
        if (this.contenu==null)
        {
            throw new NoLiquidTypeException("Impossible ajouter liquides avant de definir le type de liquide de la citerne");
        }
        if (quantite<=0 || quantite>1)
        {
            throw new IllegalArgumentException("Quantité <=0 ou >1");
        }

        double ajout= (this.capacite*quantite);

        if (this.volume+ajout>this.capacite)
        {
            this.volume=this.capacite;
            throw new MaximumLiquidCapacityExceededException();
        }
        else
        {
            this.volume+=ajout;
        }
    }

    public void enleverLiquide(int quantite) throws NoLiquidTypeException,BelowMinimumLiquidCapacityException
    {
        if (this.contenu==null)
        {
            throw new NoLiquidTypeException("Impossible enlever liquides avant de definir le type de liquide de la citerne");
        }
        if (quantite<CAP_MIN || quantite>this.capacite)
        {
            throw new IllegalArgumentException("Quantité <CAP_MIN ou >CAP_MAX");
        }
        if (this.volume-quantite<CAP_MIN)
        {
            this.volume=CAP_MIN;
            throw new BelowMinimumLiquidCapacityException();
        }
        else
        {
            this.volume-=quantite;
        }
    }

    public void enleverLiquidePourcent(double quantite) throws NoLiquidTypeException,BelowMinimumLiquidCapacityException
    {
        if (this.contenu==null)
        {
            throw new NoLiquidTypeException("Impossible enlever liquides avant de definir le type de liquide de la citerne");
        }
        if (quantite<=0 || quantite>1)
        {
            throw new IllegalArgumentException("Quantité <=0 ou >1");
        }
        double volEnlever=this.capacite*quantite;
        if (this.volume-volEnlever<CAP_MIN)
        {
            this.volume=CAP_MIN;
            throw new BelowMinimumLiquidCapacityException();
        }
        else
        {
            this.volume-=volEnlever;
        }
    }

    public void nettoyer()
    {
        this.contenu=null;
        this.volume=0;
    }

    public int compareA(Object o)
    {
        if (o==null)
        {
            throw new NullPointerException("Le parametre o est null");
        }
        if (!(o instanceof Citerne))
        {
            throw new ClassCastException("Le parametre o n'est pas un objet de type Citerne");
        }
        Citerne c2=(Citerne) o;
        int result;
        if(this.volume<c2.volume)
        {
            result=-1;
        }
        else if(this.volume>c2.volume)
        {
            result=1;
        }
        else
        {
            if(this.capacite<c2.capacite)
            {
                result=-1;
            }
            if(this.capacite>c2.capacite)
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
        if (!(o instanceof Citerne))
        {
            throw new ClassCastException("Le parametre o n'est pas un objet de type Citerne");
        }
        boolean result=false;
        Citerne c2= (Citerne) o;
        boolean verCapacite= this.capacite==c2.capacite;
        boolean verType=this.contenu.type.equals(c2.contenu.type);
        boolean verDate=this.dateCreation.isEqual(c2.dateCreation);
        boolean verVolume=this.volume==c2.volume;
        if(verCapacite&&verType&&verDate&&verVolume)
        {
            result=true;
        }
        return result;
    }

    @Override
    public String toString() 
    {
        return "Citerne n°" + this.id + ", " + this.getTypeLiquide() + ", capacite : " + this.capacite + " m3, " + "mise en service : " + 
        this.dateCreation + ", volume occupe : " + this.getQuantiteLiquide() + " m3";
    }

}
