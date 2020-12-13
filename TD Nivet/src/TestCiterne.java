public class TestCiterne 
{
    public static void main(String[] args) throws IllegalCapacityException,NoLiquidTypeException,
    MaximumLiquidCapacityExceededException,IsNotCleanException,BelowMinimumLiquidCapacityException 
    {
        Citerne c1=new Citerne(3000, Citerne.Liquide.EAU);
        Citerne c2=new Citerne(3000, Citerne.Liquide.VIN);
        System.out.println(c1);
        System.out.println(c2);
        //assert c1.equals(c2); Les assert ne marchent pas sur ma machine, j'arrête donc de les utiliser
        assert !c1.equals(c2);
        c1.ajouterLiquide(300);
        assert (c1.getQuantiteLiquide()==300); 
        System.out.println(c1.getQuantiteLiquide());
        System.out.println(Citerne.plusAncienne(c1,c2));
        System.out.println(c1.getTypeLiquide());
        System.out.println(c1.getQuantiteLiquide());
        System.out.println(c2.getDateCreation());
        System.out.println(Citerne.getNbCiternes());
        c2.nettoyer();
        System.out.println(c2.getTypeLiquide());
        c2.setLiquide(Citerne.Liquide.EAU);
        c2.ajouterLiquidePourcent(0.5);
        System.out.println(c2);
        c2.enleverLiquide(500);
        System.out.println(c2.toString());
        //c1.enleverLiquidePourcent(0.5); throws BelowMinimumLiquidCapacityException, fonctionnement attendue
        c2.enleverLiquidePourcent(0.2);
        System.out.println(c2);
        System.out.println(c1);
        System.out.print(c2.compareA(c1)+"\n");
        System.out.print(c2.equals(c1)+"\n");
        

        CiterneSecurisee cs1=new CiterneSecurisee(4000,Citerne.Liquide.EAU);
        CiterneSecurisee cs2=new CiterneSecurisee(4000,Citerne.Liquide.EAU,c2);
        System.out.println(cs1);
        System.out.println(cs2.toString());
        CiterneSecurisee cs3=(CiterneSecurisee) cs1.clone();
        System.out.println(cs3);
        System.out.println(cs3.equals(cs1));
        System.out.println(cs2.equals(cs1));
        System.out.println(cs2.compareA(cs1));
        System.out.println(cs1.compareA(cs3));
        cs2.ajouterLiquide(6000);
        System.out.println(cs2);
        cs2.enleverLiquide(1000);
        System.out.println(cs2);
        cs1.ajouterLiquidePourcent(0.5);
        System.out.println(cs1);
        cs2.nettoyerTropPlein();
        System.out.println(cs2);
        //cs1.ajouterLiquide(10000); throws MaximumLiquidCapacityExceededException, fonctionnement attendue
        cs1.ajouterLiquide(2300);
        System.out.println(cs1);
        cs1.nettoyer();
        System.out.println(cs1);
        cs1.setLiquide(Citerne.Liquide.HUILE);
        System.out.println(cs1);



    }
}
