import java.io.DataInputStream;
import java.util.*;
/**
 * User interface for treemap with words from text file
 * @author: Tyler King 040979598
 */
public class TreeTester {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Dictionary one = new Dictionary();
        menu(one);
    }

    public static void menu(Dictionary bring){
        boolean x=true;
        int choiceA;
        String choiceB;
        while (x){
            try {
                System.out.println("**************************************");
                System.out.println("DICTIONARY");
                System.out.println("**************************************");
                System.out.println("1. Add words to the Dictionary from file");
                System.out.println("2. Search a word in the dictionary");
                System.out.println("3. Display number of unique words in the dictionary");
                System.out.println("4. Display number of all words in the dictionary");
                System.out.println("5. Reset Dictionary");
                System.out.println("6. Ignore definite and indefinite articles");
                System.out.println("7. Exit");
                System.out.print("Enter your option: ");choiceA=input.nextInt();
                boolean run = true;
                if (choiceA==1){
                    bring.read();
                }
                else if (choiceA==2){
                    System.out.print("What word are you looking for?: ");
                    choiceB = input.next();
                    bring.search(choiceB);
                }
                else if (choiceA==3){
                    System.out.println("Dictionary has : "+bring.getWords().size()+" unique words");
                    System.out.println(bring.getWords());
                }
                else if (choiceA==4){
                    System.out.println("Dictionary has : "+bring.getTotal()+" unique words");
                }
                else if (choiceA==5){
                    bring = new Dictionary();
                }
                else if (choiceA==6){ //changes ignore to true or false based on existing condition
                    if (bring.isIgnore()){
                        bring.setIgnore(false);
                        System.out.println("Now "+bring.getIgnore());}
                    else{
                        bring.setIgnore(true);
                        System.out.println("Now "+bring.getIgnore());}
                }
                else if (choiceA==7){
                    System.out.println("Goodbye");
                    x=false;
                    run=false;
                }
                else {
                    System.out.println("Enter a value between 1-7");
                }
            }
            catch(NullPointerException | InputMismatchException e){
                System.err.println(e.getMessage());
                input.next();
            }
        }
    }//method ends


}//class ends
