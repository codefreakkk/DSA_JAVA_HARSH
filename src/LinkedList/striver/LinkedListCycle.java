package LinkedList.striver;

import java.util.*;

// not much optimized solution
public class LinkedListCycle {
    public static boolean hasCycle(Node head) {
        if(head == null) return false;

        Set<Node> map = new HashSet<>();
        Node temp = head;
        while(temp != null) {
            if(map.contains(temp)) return true;
            map.add(temp);
            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
