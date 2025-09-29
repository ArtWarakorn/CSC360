package TestSort;

import java.util.*;
public class SelectionSort {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("Plese input size of array : ");
        int n = sc.nextInt();
        int array[] = new int[n];

        for(int a = 0; a < array.length; a++) {
            array[a] = rnd.nextInt(101);
        }

        selectionSort(array);

        for(int i : array) {
            System.out.print(i + " ");
        }

        System.out.println("");

        System.out.print("Input key : ");
        int key = sc.nextInt();

        binarySearch(array, key);
    }

    private static void binarySearch(int a[], int key){
        int first = 0;
        int last = a.length-1;
        int count = 0;
        boolean check = false;

        while(first <= last) {
            count++;

            int center = (first + last)/2;
            if(a[center] == key){
                System.out.println("Found at : " + center + "\n" + "Count : " + count);
                check = true;
                break;
            }
            else if(a[center] < key)
                first = center + 1;
            else
                last = center - 1;
        }

        if(!check)
            System.out.println("Not found");
    }

    private static void selectionSort(int a[]) {

        for(int i = 0; i < a.length-1; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[i] > a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
}
