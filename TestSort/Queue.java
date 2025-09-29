package TestSort;

public class Queue {
    public static void main(String[] args) {
        Queues q = new Queues(5);
        q.addQ(12);
        q.addQ(10);
        q.addQ(15);

        System.out.println("Q1 : " + q.getQ());
        System.out.println("Q2 : " + q.getQ());
    }
}