package ExamSort;

import java.util.Scanner;
import Sort.RandomArray;

public class ExTest {
    public static void main(String[] args) {

        RandomArray random = new RandomArray(10);
        int[] array = random.randomArray();

        ExSort sort = new ExSort();
        sort.bubbleSort(array);

        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        BinarySearch search = new BinarySearch();
        search.binarySearch(array, key);
    }
}
