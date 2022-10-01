package LinkedList;

public class SplitACircularLinkedListInTwoHalves {
    public static void splitList(Node head) {
        Node slow = head;
        Node fast = head.next;
        Node temp = head;

        while(fast != head && fast.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node head1 = head;
        Node head2 = slow.next;
        slow.next = head1;

        Node current = head2;
        while(current.next != head) {
            current = current.next;
        }

        current.next = head2;
    }

    public static void main(String[] args) {

    }
}
