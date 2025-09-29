package Sort;

public class QuickSort {

    private static void quickSort(int[] array, int start, int end) {

        if(end <= start) return;
        int pivot = patition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int patition(int[] array, int start, int end) {

        int i = start - 1;
        int pivot = array[end];
        int tmp = 0;

        for(int j = start; j <= end; j++) {

            if (array[j] < pivot) {
                i++;
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        i++;
        tmp = array[i];
        array[i] = array[end];
        array[end] = tmp;

        return i;

    }
    public void getQuickSort(int[] array) {

        quickSort(array, 0, array.length-1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}