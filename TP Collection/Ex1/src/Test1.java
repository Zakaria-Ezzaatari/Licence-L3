public class Test1
{
    public static void main(String[] args) 
    {

    PairesGen<Integer,String> test1=new PairesGen<>(10, "banana");
    PairesGen<String,Integer> test2=new PairesGen<String,Integer>("101test", 000);
    
    System.out.println(test1.getEl1());
    System.out.println(test2.getEl2());

    test2.setEl2(2000);

    System.out.println(test2.getEl2());
    
    }
   
}
