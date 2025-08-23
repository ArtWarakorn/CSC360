import java.util.Random;
import java.util.Scanner;

public class Wreek1_5 {

    /*
     * create array 1 dimantion use class Scanner for input n 
     * and random charactor A-Z search charactor 
     */

    public static void printResult() {
        Scanner scanner = new Scanner(System.in); //Class Scanner
        Random random = new Random();             //Class Random

        int n;
        String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //set of charactor

        System.out.print("Please input size of array (n): ");
        n = scanner.nextInt(); //function get value (n) from keybord

        int charArray[] = new int[n];

        for(int i = 0; i < charArray.length; i++) { // loop array and random charactor
            charArray[i] = random.nextInt(0, txt.length() + 1);
            char charactor = txt.charAt(charArray[i]);
            System.out.print(charactor);
        }
        System.out.println("");

        System.out.print("Please input What charactor your want to find : ");
        String getChar = scanner.next(); //input charactor

        //function tranfer char to number
        int charNumder = charToInt(getChar);
        int searchChar = search(charArray, charNumder);

        //chack number
        if(searchChar != -1) 
            System.out.println("Found in index : " + searchChar);
        else
            System.out.println("Not found");

    }

    public static int charToInt(String inputChar){

        String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 0; i < txt.length(); i++) {

            String txtToChar = txt.charAt(i)+"";
            if(inputChar.equals(txtToChar))
                return i;
        }

        return -1;
    }
    
    public static int search(int charArray[], int findChar) { //class for search

        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] == findChar)
                return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        printResult();
    }
}
