package TestSort;

import Sort.MergeSort;
import Sort.QuickSort;
import Sort.RandomArray;
import Sort.ShellSort;
import java.util.Scanner;

public class TestSort {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Input Size Of Array : ");
        int array_size = scan.nextInt();

        RandomArray rmArray = new RandomArray(array_size); //random number in array size
        int[] array = rmArray.randomArray();

        System.out.println("Merge Sort : ");
        MergeSort mrSort = new MergeSort();
        mrSort.getMergSort(array);

        System.out.println("Quick Sort : ");
        QuickSort qSort = new QuickSort();
        qSort.getQuickSort(array);

        System.out.println("Shell Sort");
        ShellSort shell = new ShellSort();
        shell.getShellSort(array);

    }
}
