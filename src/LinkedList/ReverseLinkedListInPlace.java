package LinkedList;

// reverse linked list iterative (In place)
public class ReverseLinkedListInPlace {
    public static Node reverseList(Node node) {
        if(node == null || node.next == null) return node;
        Node previous = null;
        Node present = node;
        Node nxt = present.next;

        while(present != null) {
            present.next = previous;
            previous = present;
            present = nxt;
            if(nxt != null) nxt = nxt.next;
        }

        return previous;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(10);
        s.insertLast(20);
//        s.insertLast(30);
//        s.insertLast(40);

        Node head = reverseList(s.head);
        s.display(head);
    }
}
