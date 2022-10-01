package LinkedList;

public class RemoveNthNodeFromEndOfList {
    public static Node removeNthNodeFromEnd(Node head, int n) {
        if(head == null) return head;

        Node dummy = new Node(-1), slow = dummy;
        slow.next = head;
        Node fast = head;

        // move fast n times forward
        for(int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }

        // move slow forward
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
