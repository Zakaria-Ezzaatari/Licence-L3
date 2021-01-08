

import java.util.*;
import java.io.*;

public class Anagramme 
{
    private int threshold;
    private ArrayList<String> wordlist = new ArrayList<String>();
    private Map<Integer, ArrayList<String>> anagrammap = new TreeMap<Integer, ArrayList<String>>();
    
    Anagramme(String filename,int threshold)
    {
        this.threshold=threshold;
        this.readFile(filename);
    }

    private void readFile(String filename) 
    {
        try(Scanner scanner = new Scanner(new File(filename)))
        {
            do {
                String currentLine = scanner.nextLine();
                wordlist.add(currentLine);
            } while (scanner.hasNext());

            for (int i = 0; i < wordlist.size(); i++) 
            {
                ArrayList<String> anagram = new ArrayList<String>();
                for (int j = 0; j < wordlist.size(); j++) 
                {
                    if(i != j){
                        Boolean check = checkAnagram(wordlist.get(i), wordlist.get(j));
                        if(check){ // If word is an anagram we add to arraylist
                            anagram.add(wordlist.get(j));
                        }
                    }
                }
                if(anagram.size() > threshold)
                { 
                    anagram.add(wordlist.get(i));
                    anagrammap.put(i,anagram);
                }

            }
        } 
        catch (FileNotFoundException e)
        {
            System.err.println("Incorrect filename or file not existant");
        }
        
    }

    public Map<Integer, ArrayList<String>> getAnagram() 
    {
        return this.anagrammap;
    }
    
    public boolean checkAnagram(String s1, String s2)
    {
        s1 = s1.replaceAll("\\s", "");
        s2 = s2.replaceAll("\\s", "");
        
        if(s1.length() != s2.length())
        {
            return false;
        }
        
        else
        {
            char[] arr1 = s1.toLowerCase().toCharArray();
            char[] arr2 = s2.toLowerCase().toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);
            
            return (Arrays.equals(arr1, arr2));
        }
    }
}
