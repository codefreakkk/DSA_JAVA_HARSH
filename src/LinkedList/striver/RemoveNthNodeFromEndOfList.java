package LinkedList.striver;

public class RemoveNthNodeFromEndOfList {
    public static Node removeNthFromEnd(Node head, int n) {
        if(head == null) return head;

        Node dummy = new Node(-1), slow = dummy;
        Node fast = slow;
        slow.next = head;

        for(int i = 1; i <= n; i++) fast = fast.next;

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
