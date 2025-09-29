package TestSort;

public class Stacked {

    private int top;
    private int a[];

    public Stacked(int size) {
        top = -1;
        a = new int[size];
    }

    public void push(int num) {
        top++;
        a[top] = num;
    }

    public int pop() {

        int buff = a[top];
        top--;
        return buff;
    }

}