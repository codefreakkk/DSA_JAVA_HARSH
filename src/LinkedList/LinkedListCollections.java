package LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListCollections {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
//        list.remove(2); // pass index
//        System.out.println(list.indexOf(130)); // gives index of element if element not found gives -1
//        System.out.println(list.size());

        ListIterator l = list.listIterator(0);
//        l.next();
//        System.out.println(l.next());
//        list.remove(l.next());
//        System.out.println(list);


    }
}
