package TestSort;

public class Debug {
    public static void main(String[] args) {
        int array[] = {2,3,5,3,5,8};
        for(int i = 0; i < array.length-1; i++) {
            for(int j = 0; j < array.length-i-1; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }
}
