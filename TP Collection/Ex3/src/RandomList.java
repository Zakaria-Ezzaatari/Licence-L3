import java.util.*;

public class RandomList 
{
    private static Random r = new Random();
    private static final int MAX = 1000;

    private List<Integer> list = new ArrayList<Integer>();

    public RandomList(int n) 
    {
        for(int i = 0; i < n; i++) 
        {
            this.list.add(RandomList.r.nextInt(RandomList.MAX));
        }

        Collections.sort(this.list);
    }

    public List<Integer> getList() 
    { 
        return this.list; 
    }
}  
