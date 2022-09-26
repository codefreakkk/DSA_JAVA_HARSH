package LinkedList;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


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

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        boolean flag = false;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                flag = true;
                break;
            }
        }

        if(flag == true) {
            slow = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
        else return null;
    }
}
