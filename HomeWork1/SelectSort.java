package HomeWork1;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        //Create scanner and Random object

        //time start
        long start, stop;
        Date time1 = new Date();
        start = time1.getTime();

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
        
        // Selection sort algorith
        for(int i = 0; i < a.length-1; i++) {
            int min_idx = i;
            for(int j = i + 1; j < a.length; j++) {
                if(a[j] < a[min_idx]) 
                    min_idx = j;
                }
            
            // Swap the found minimum element with the first element
            int tmp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = tmp;
        }

        // Print the sorted array
        System.out.print("Sorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        scan.close();

        //stop time
        Date time2 = new Date();
        stop = time2.getTime();
        double runTime = (double)(stop - start)/1000.0;

        System.out.println(runTime + " sec");
    }
}
