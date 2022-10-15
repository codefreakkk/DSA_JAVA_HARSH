package LinkedList;

public class DeleteMiddleNodeOfLinkedList {
    public static Node deleteMiddle(Node head) {
        if(head.next == null) return null;

        // edge case
        if(head.next.next == null) {
            head.next = null;
            return head;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
