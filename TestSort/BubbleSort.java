package TestSort;

public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {9,1,7,5,2,8,6,3,4};

        bubbleSort(a);

        for(int i : a){
            System.out.print(i + " ");
        }
    }

    private static void bubbleSort(int a[]) {
        for(int i = 0; i < a.length-1; i++) {
            for(int j = 0; j < a.length-i-1; j++) {
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }
}
