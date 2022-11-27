package LinkedList.striver;

import java.util.*;

public class FindStartingPointOfCycle {
    // brute force solution (not optimized)
    public static Node detectCycle1(Node head) {
        if(head == null) return head;

        Set<Node> set = new HashSet<>();
        Node temp = head;

        while(temp != null) {
            if(set.contains(temp)) return temp;
            set.add(temp);
            temp = temp.next;
        }

        return null;
    }


    // this is optimized solution
    public static Node detectCycle(Node head) {
        if(head == null) return head;

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
