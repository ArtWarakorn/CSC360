package Sort;

public class MergeSort {

    private static void mergeSort(int[] arr) {

        int length = arr.length;
        if(length <= 1) return; //base case

        int mid = length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];

        int i = 0; //leftArray
        int j = 0; //rightArray

        for(; i < length; i++){
            
            if(i < mid) {
                leftArray[i] = arr[i];
            }

            else {
                rightArray[j] = arr[i];
                j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, arr);
    }


    private static void merge(int[] leftArray, int[] rightArray, int[] array) {

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {

            if(leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
            
    }

    public void getMergSort(int[] array) {

        mergeSort(array);

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
