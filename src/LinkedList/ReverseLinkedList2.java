package LinkedList;

public class ReverseLinkedList2 {
    public static Node reverseBetween(Node head, int left, int right) {
        if(head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node current = head;

        for(int i = 0; i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        // this is the last node at left side after cutting down the reverse sub linked list
        Node last = prev;
        Node newEnd = current;

        // reverse the linked list for given size
        Node nxt = current.next;
        for(int i = 0; i < (right - left) + 1; i++) {
            current.next = prev;
            prev = current;
            current = nxt;
            if(nxt != null) nxt = nxt.next;
        }

        // connect the last element from the left side after reversing the sub linked list
        if(last != null) last.next = prev;
        else head = prev;

        // connect the last node of reversed linked list with the first remaining node of right side
        newEnd.next = current;
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
//        s.insertLast(2);
//        s.insertLast(3);
//        s.insertLast(4);
//        s.insertLast(5);
        int left = 1, right = 1;

        Node head = reverseBetween(s.head, left, right);
        s.display(head);
    }
}
