package Advance_Maths;

import java.util.LinkedList;

public class test {
    

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("d");
        ll.add("e");
        LinkedList temp = ll.iterator();
        int k = 2;
        while (k-- > 0) {
            temp = temp.removeFirst();
        }
    }
}
