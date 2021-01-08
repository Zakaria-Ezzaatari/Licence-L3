
import java.util.ArrayList;
import java.util.Arrays;

public class Test4 
{
    public static void main(String[] args) 
    {
        /* insert in command prompt $java Test4 arg0="lexical" or "military" or "reverse" arg1 arg2 arg3 ... argn */
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList(args));
        Sorter test=new Sorter(list);
        System.out.println(test.getSorted());
    }
    
    
    

}
