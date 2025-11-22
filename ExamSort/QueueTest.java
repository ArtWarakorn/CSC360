package ExamSort;

import javax.naming.ldap.StartTlsRequest;

public class QueueTest {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.inputNumber(12);
        q.inputNumber(10);
        q.inputNumber(5);
        q.inputNumber(2);
        q.inputNumber(20);

        q.outputNumber();
        q.outputNumber();
        q.outputNumber();
        q.outputNumber();
        q.outputNumber();
    }
}

class Queue {
    int start = -1;
    int end = -1;
    int showNum = 0;
    int[] array;

    public Queue(int size) {
        array = new int[size];
    }

    public void inputNumber(int num) {
        if(start < 0 && end < 0) {
            start++;
            end++;
            array[end] = num;
        }
        else if (end > 0 || start > 0) {
            end++;
            array[end] = num;
        }
        else if(end > array.length) {
            System.out.println("Array full");
        }
    }

    public void outputNumber() {

        if(start >= 0 && end >= 0) {
            
            showNum = array[start];
            System.out.println("Array[" + start + "] : " + showNum);
            array[start] = 0;
            start++;

        }

        else if(start > array.length && end > array.length) {
            System.out.println("Array null");
        }
    }
}
