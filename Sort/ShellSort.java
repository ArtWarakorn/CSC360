package Sort;

public class ShellSort {

    private static void shellSort(int[] array) {

        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {
                int tmp = array[i];

                int j;

                for (j = i; j >= gap && array[j - gap] > tmp; j -= gap) {
                    array[j] = array[j - gap];
                }

                array[j] = tmp;
            }

        }
    }

    public void getShellSort(int[] array) {

        shellSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
