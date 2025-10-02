package ExamSort;

public class ExSort {

    public void insetionSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length-1; j++) {

                int tmp = a[j];

                if(a[i] > a[j]) {

                    a[j] = a[i];
                    a[i] = tmp;
                }

            }
        }

    }

    public void selectionSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length-1; j++) {
                if (a[j] < a[i]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public void bubbleSort (int[] a) {

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length-1; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }
}
