package TestSort;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Wreek1_5 {

    /*
     * 1. create array 1 dimantion use class Scanner for input n 
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

    //*************************************************End*******************************************************//

    /*
     * 2. input Number put in array 1 dimantion size of array (n)
     *    and sort Number 
     */

    public static String inputFunction(String text) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        String input = scanner.nextLine();

        return input;
    }
    
    public static int[] inputArray() {

        int n = Integer.parseInt(inputFunction("Please input size of array(n): "));
        int[] numArray = new int[n];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numArray[i] = scanner.nextInt();
        }

        return numArray;

    }

    public static void sortNumber(int[] numArray) {
        
        Arrays.sort(numArray);
 
        System.out.println("You entered:");
        for (int i = 0; i < numArray.length; i++) {
            System.out.println("Element at index " + i + ": " + numArray[i]);
        }

    }

    public static void main(String[] args) {
        //printResult();
        sortNumber(inputArray());
    }
}
