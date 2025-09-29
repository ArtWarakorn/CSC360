package TestSort;

import java.util.LinkedList;

public class LinkList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("Hello");
        list.add("Text");
        list.add("Java");

        System.out.println("List : " + list);

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("Text")) {
                System.out.println("Found at " + i);
                break;
            }
        }
    }   
}
