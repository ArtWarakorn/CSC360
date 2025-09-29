package HomeWork1;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int array[]) {
    for(int i = 0; i < array.length - 1; i++) {
        for(int j = 0; j < array.length - i - 1; j++) {
            if(array[j] > array[j+1]) {
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }
}
    public static void main(String[] args) {
        //time start
        long start, stop;
        start = System.nanoTime();
        
        //Create scanner and Random object

        Scanner scan = new Scanner(System.in);
        Random rd = new Random();

        //Input value from keybord
        System.out.print("Enter size of array (n) : ");
        int n = scan.nextInt();

        //create array size (n)
        int a[] = new int[n];   

        //loop random value in array
        System.out.print("Original array: ");
        for(int i = 0; i < a.length; i++) {
            a[i] = rd.nextInt(0,11);
            System.out.print(a[i] + " ");
        }
        System.out.println(); // Add a newline for better formatting
        
        // Bubble sort algorith
        bubbleSort(a);

        // Print the sorted array
        System.out.print("Sorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        scan.close();

        //stop time

        stop = System.nanoTime();
        double runTime = (double)(stop - start)/1_000_000_000.0;    

        System.out.println(runTime + " sec");
    }
}        
