package TestSort;

public class Stack {
    public static void main(String[] args) {
        Stacked st = new Stacked(5); 
        
        st.push(10);
        st.push(11);
        st.push(15);
        st.push(12);
        st.push(18);

        System.out.println("POP 1 : " + st.pop());
        System.out.println("POP 2 : " + st.pop());
    }
}