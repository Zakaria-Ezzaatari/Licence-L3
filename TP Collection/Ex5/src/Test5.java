public class Test5 
{
    public static void main(String[] args) 
    {
        Personne p1=new Personne("Zakaria","Ezzaatari",25,03,1999,5,"Z.I de Tragone","20620","Biguglia");
        Personne p2=new Personne("Not","Me",25,03,1998,5,"Z.I de Tragone","20620","Biguglia");
        System.out.println(p1.compareTo(p2));
        System.out.println(p2.compareTo(p1));
        System.out.println(p1.compareTo(p1));

    }
}
