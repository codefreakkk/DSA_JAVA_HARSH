package LinkedList;

public class RotateDoublyLinkedList {
    public static Node rotateDll(Node head, int p) {
        // traverse till last
        Node tail = head;
        while(tail.next != null) tail = tail.next;

        // move p times forward
        Node current = head;
        for(int i = 0; i < p - 1; i++) current = current.next;

        // make connections
        head.prev = tail;
        tail.next = head;
        head = current.next;
        head.prev = null;
        current.next = null;

        return head;
    }

    public static void main(String[] args) {

    }
}
