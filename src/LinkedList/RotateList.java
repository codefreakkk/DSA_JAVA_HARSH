package LinkedList;

public class RotateList {
    public static Node  rotateRight(Node head, int k) {
        if(head == null || head.next == null || k <= 0) return head;

        // count the length of list
        Node tail = head;
        int length = 0;
        while(tail.next != null) {
            length++;
            tail = tail.next;
        }
        length++;

        // number of rotations
        int rotation = k % length;
        int count = length - rotation;

        Node current = head;
        for(int i = 0; current != null && i < count - 1; i++) current = current.next;

        // make connections
        tail.next = head;
        head = current.next;
        current.next = null;

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(2);
        s.insertLast(4);
        s.insertLast(7);
        s.insertLast(8);
        s.insertLast(9);
//        s.insertLast(6);
        int k = 3;

        s.display(s.head);
        Node head = rotateRight(s.head, k);
        s.display(head);
    }
}
