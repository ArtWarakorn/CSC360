package ExamSort;

import Sort.RandomArray;

public class ExTest {
    public static void main(String[] args) {

        RandomArray random = new RandomArray(10);
        int[] array = random.randomArray();

        ExSort sort = new ExSort();
        sort.bubbleSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
