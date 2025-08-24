import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class Wreek1 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input size of array (n) : ");
        int n = scanner.nextInt();

        int numArray[] = new int[n];

        //call function random numder
        int randomArr[] = randomArray(numArray);

        //convert array to String
        String num = Arrays.toString(randomArr);
        System.out.println(num + " ");

        System.out.print("Input value search : ");
        int value = scanner.nextInt();

        int index = searchNumber(randomArr, value);

        //check number in array
        if(index != -1)
            System.out.println("Found at " + index);
        else
            System.out.println("Not found!!");
    }

    public static int[] randomArray(int[] numArray) {

        Random random = new Random();
        //random at value to array
        for(int i = 0; i < numArray.length; i++){
            numArray[i] = random.nextInt(0, 101);
            //System.out.print(numArray[i] + " ");
        }
        //System.out.println("");

        return numArray;
    }

    public static int searchNumber(int numArr[], int num){

        for(int i = 0; i < numArr.length; i++) {
            if(numArr[i] == num)
                return i;
        }

        return -1;
    }
}
