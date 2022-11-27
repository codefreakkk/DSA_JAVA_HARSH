package LinkedList;

public class SwapNodesInPairs {
    public static Node swapPairs(Node head) {
        if(head == null || head.next == null) return head;

        Node current = head.next.next;
        Node prev = head;
        head = head.next;
        head.next = prev;

        while(current != null && current.next != null) {
            prev.next = current.next;
            prev = current;
            Node temp = current.next.next;
            current.next.next = current;
            current = temp;
        }

        prev.next = current;
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(3);
        s.insertLast(4);
        Node head = swapPairs(s.head);
        s.display(head);

    }
}
