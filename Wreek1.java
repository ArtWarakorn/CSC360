import java.util.Scanner;
import java.util.Random;

class Wreek1 {

    public static void main(String[] args) {
        showSearch();
    }

    public static void showSearch(){

        //call odject random and Scanner
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input size of array (n) : ");
        int n = scanner.nextInt();

        int numArray[] = new int[n];

        //random at value to array
        for(int i = 0; i < numArray.length; i++){
            numArray[i] = random.nextInt(0, 101);
            System.out.print(numArray[i] + " ");
        }
        System.out.println(""); //enter new line

        System.out.print("Input value : ");
        int num = scanner.nextInt();

        //call function searchNumber at value to index
        int index = searchNumber(numArray, num);

        if(index != -1)
            System.out.println("Found at index : " + index);
        else
            System.out.println("Not Found");
    }

    public static int searchNumber(int numArr[], int num){

        for(int i = 0; i < numArr.length; i++) {
            if(numArr[i] == num)
                return i;
        }

        return -1;
    }
}
