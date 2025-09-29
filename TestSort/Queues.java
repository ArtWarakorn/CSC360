package TestSort;

public class Queues { 
    //1 0
    //2 1 
    //3 2 p1,
    //4 3 p2=0 buff=1

    private int p1,p2;
    private int a[];

    public Queues(int size) {
        p1 = -1;
        p2 = -1;
        a = new int[size];
    }

    public void addQ(int num) {
        if(p1 < 0 && p2 < 0) {
            p1++;
            p2++;

            a[p2] = num;

        } else if(p2 > 0 || p1 > 0) {
            p2++;
            a[p2] = num;
        } else if(p2 > a.length) System.out.println("Out of Index");
    }

    public int getQ() {
        int buff = 0;

        if(p1 >= 0 && p2 >= 0) {
            buff = a[p2];
            a[p2] = 0;
            p1++;
        }

        return buff;
    }

}
