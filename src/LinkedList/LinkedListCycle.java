package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

// use this code will not give null pointer exception

//        Node slow = head;
//        Node fast = head;
//
//        while(slow != null && fast != null) {
//        fast = fast.next;
//        if(fast != null) fast = fast.next;
//
//        slow = slow.next;
//
//        if(slow == fast) return slow;
//        }
//
//        return null;




// linked list cycle detection
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) return true;
        }

        return false;
    }
}
