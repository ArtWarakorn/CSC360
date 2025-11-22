package ExamSort;

public class BinarySearch {

    public static void binarySearch(int[] array, int key) {

        int start = 0;
        int end = array.length - 1;
        int count = 0;
        int center;
        boolean found = false;

        while (start <= end) {

            count++;

            center = start + (end - start) / 2;

            if (key == array[center]) {

                System.out.println("Find at : " + center);
                found = true;
                break;
            }

            else if (key < array[center]) {
                end = center - 1;
            }

            else {
                start = center + 1;
            }
        }

        if (!found) {
            System.out.println(key + " Not found");
        }
    }
}
