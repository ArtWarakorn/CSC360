package Sort;

import java.util.Random;

public class RandomArray {

    public RandomArray() {
        System.out.println("null array");
    }

    private int size = 0;
    private int bound = 0;

    public RandomArray(int n) {
        size = n;
        bound = 10; //set Defult Bound
    }

    public RandomArray(int n, int bound) {
        size = n;
        this.bound = bound;
    }

    public int[] randomArray() {

        Random rm = new Random();

        int[] array = new int[size];

        System.out.println("Data : ");

        for (int i = 0; i < array.length; i++) {
            array[i] = rm.nextInt(bound);
            System.out.print(array[i] + " ");
        }
        System.out.println("");

        return array;

    }
}
