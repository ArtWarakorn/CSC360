package ExamSort;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack(6);

        stack.push(4);
        stack.push(6);
        stack.push(8);
        stack.push(4);
        stack.push(10);
        stack.push(11);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        //stack.pop();

    }
}

class Stack {

    int[] array;
    int i;

    Stack(int size) {
        array = new int[size];
        i = -1;
    }


    public void push(int num) {
        
        i++;

        if(i < array.length) {
            array[i] = num;
        }
        else
            System.out.println("Array is full!!");
        

    }

    public void pop() {

        if(i != -1) {

            int showPop = array[i];
            array[i] = 0;
            System.out.println("array["+i+"] : " + showPop);
            i--;
        }
        else
            System.out.println("Array is null");
    }

}
