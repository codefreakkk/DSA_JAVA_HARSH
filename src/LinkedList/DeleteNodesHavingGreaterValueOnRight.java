package LinkedList;

public class DeleteNodesHavingGreaterValueOnRight {
    public static Node reverse(Node head) {
        Node prev = null;
        Node present = head;
        Node nxt = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = nxt;
            if(nxt != null) nxt = nxt.next;
        }

        return prev;
    }
    public static Node compute(Node head) {
        int max = Integer.MIN_VALUE;
        Node newHead = reverse(head);
        Node prev = newHead;
        Node current = newHead;

        while(current != null) {
            if(current.value >= max) {
                max = current.value;
                prev = current;
                current = current.next;
            }
            else {
                prev.next = current.next;
                current = current.next;
            }
        }

        newHead = reverse(newHead);
        return newHead;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(12);
        s.insertLast(15);
        s.insertLast(10);
        s.insertLast(11);
        s.insertLast(5);
        s.insertLast(6);
        s.insertLast(2);
        s.insertLast(3);
        Node head = compute(s.head);
        s.display(head);
    }
}
