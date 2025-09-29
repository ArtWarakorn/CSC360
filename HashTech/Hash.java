package HashTech;

import java.util.*;

public class Hash {
    public static void main(String[] args) {
        Hashtable<String, String> table = new Hashtable<>(10);

        //put subject_ID , subject_Name
        table.put("csc362", "Data base System");
        table.put("csc360", "Data Structure and algorithm");
        table.put("csc481", "System Design");
        table.put("csc250", "OOP programming");

        for(String key : table.keySet()) {
            System.out.println(key.hashCode()%10 + " " + key + " " + table.get(key));
        }
    }
}
