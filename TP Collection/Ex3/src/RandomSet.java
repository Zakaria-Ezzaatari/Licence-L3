import java.util.*;

public class RandomSet 
{
    private static Random r = new Random();
    private static final int MAX = 1000;
    
    private Set<Integer> set = new TreeSet<Integer>();
    
    public RandomSet(int n) 
    {
        for(int i = 0; i < n; i++) 
        {
            this.set.add(RandomSet.r.nextInt(RandomSet.MAX));
        }
    }
    
    public Set<Integer> getSet() 
    { 
        return this.set;
    } 

}
