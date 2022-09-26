package LinkedList.codehelp;

public class ReverseLinkedListIteration {
    public static Node reverseList(Node head) {
        if(head == null || head.next == null) return head;

        Node prev = null;
        Node current = head;
        Node nxt = current.next;

        while(current != null) {
            current.next = prev;
            prev = current;
            current = nxt;
            if(nxt != null) nxt = nxt.next;
        }

        return prev;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(3);
        s.insertLast(4);
        s.insertLast(5);
        s.display();
        Node head = reverseList(s.head);
        s.display(head);

    }
}
