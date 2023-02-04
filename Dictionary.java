import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/** uses treemap to create a dictionary from the words in a treemap
 * @author: Tyler King 040979598
 */

public class Dictionary {
    /*Stores words*/
    private Map<String,Integer> words = new TreeMap<String,Integer>();
    /*Choice to include or remove definite and indefinite articles*/
    private boolean ignore = false;
    /*Holds number of words iterated*/
    private int total;
    Scanner input = new Scanner(System.in);
    public Dictionary(){
        words= new TreeMap();
    }


    /**
     * searches for given string inside Treemap
     * returns #of occurrences
     * @param search given string
     */
    public void search(String search){
    if (words.size()<=0){
        System.out.println("Dictionary not created");
    }
    else {
        if (words.containsKey(search)) {
            System.out.println("Word found in the dictionary "+words.get(search)+" times");
        } else {
            System.out.println("Word not found in dictionary");
        }
    }
}

    /**
     * Reads file Raven.txt to TreeMap
     * Counts the amount of times while loop runs in total variable
     * Removes non letter or space characters
     */
    public void read() {
    File file = new File("src/Raven.txt");
    String[] hold;
    try(Scanner text = new Scanner(file)) {
        System.out.println("File Found");
        while (text.hasNextLine()){
            hold= text.next().split(" ");
            for (int i =0;i<hold.length;i++) {
                hold[i]=hold[i].toLowerCase();
                hold[i]=hold[i].replaceAll(",","");
                hold[i]=hold[i].replaceAll("!","");
                hold[i]=hold[i].replaceAll("'","");
                hold[i]=hold[i].replaceAll("\"","");
                hold[i]=hold[i].replaceAll(";","");
                hold[i]=hold[i].replaceAll("\\?","");
                hold[i]=hold[i].replaceAll("\\(","");
                hold[i]=hold[i].replaceAll("\\)","");
                hold[i]=hold[i].replaceAll("\\.","");
                if (words.containsKey(hold[i])){
                    words.put(hold[i],words.get(hold[i])+1);
                }
                else {
                words.put(hold[i],i+1);}
                total++;
            }
        }
        if (ignore){
            words.remove("the");
            words.remove("a");
            words.remove("an");
        }
    }
    catch (FileNotFoundException e){System.out.println("No such file "+e.getMessage());}
}
    //getters and setters
    public boolean getIgnore() { return ignore; }

    public void setIgnore(boolean ignore) {
    this.ignore = ignore;
    }

    public boolean isIgnore() {
        return ignore;
    }

    public Map<String,Integer> getWords() {
        return words;
    }

    public void setWords(TreeMap<String,Integer> words) {
        this.words = words;
    }

    public int getTotal() {
        return total;
    }
}//class end



