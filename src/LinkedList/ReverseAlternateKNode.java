package LinkedList;

public class ReverseAlternateKNode {
    public static Node reverseAlternateKNode(Node head, int k) {
        if(head == null || head.next == null || k == 1) return head;

        Node prev = null;
        Node current = head;

        while(current != null) {
            Node newEnd = current;
            Node last = prev;

            Node nxt = current.next;
            for(int i = 0; i < k; i++) {
                current.next = prev;
                prev = current;
                current = nxt;
                if(nxt != null) nxt = nxt.next;
            }

            if(last != null) last.next = prev;
            else head = prev;

            newEnd.next = current;

            // skip k elements
            for(int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(3);
        s.insertLast(4);
        s.insertLast(5);
        s.insertLast(6);
        s.insertLast(7);
        s.insertLast(8);
        s.insertLast(9);

        s.display(s.head);
        Node head = reverseAlternateKNode(s.head, 3);
        s.display(head);
    }
}
