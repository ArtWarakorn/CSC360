public class Swap {
    public static void main(String[] args) {
        int a[] = {3,7,5};

        for(int i = 0; i < a.length-1; i++) {
            int min = i;
            for(int j = i+1; j < a.length; j++){

                if(a[j] < a[min]){

                    

                    System.out.print(a[j] + " ");
                }
            }
        }
    }
}
