import java.util.ArrayList;
import java.util.Comparator;

public class Sorter
{
    private String type = "";
    private ArrayList<String> sorted;

    public Sorter(ArrayList<String> list) 
    {
        this.type = list.get(0);
        list.remove(0);
        switch (type.toUpperCase()){
            case "LEXICAL":
                this.sorted = this.getLexical(list);
                break;
            case "MILITARY":
                this.sorted = this.getMilitary(list);
                break;
            case "REVERSE":
                this.sorted = this.getReverse(list);
                break;
        }
    }

    private ArrayList<String> getLexical(ArrayList<String> list)
    {
        ArrayList<String> res = new ArrayList<String>(list.size());
        for(String element : list)
        {
            res.add(element);
        }

        res.sort(Comparator.naturalOrder());
        return res;
    }

    private ArrayList<String> getMilitary(ArrayList<String> list)
    {
        ArrayList<String> res = new ArrayList<String>(list.size());
        for(String element : list)
        {
            res.add(element);
        }

        res.sort(new Military());
        return res;
    }

    private ArrayList<String> getReverse(ArrayList<String> list)
    {
        ArrayList<String> res = new ArrayList<String>(list.size());
        for(String element : list)
        {
            res.add(element);
        }

        res.sort(Comparator.reverseOrder());
        return res;
    }

    public ArrayList<String> getSorted()
    {
        return this.sorted;
    }

}
