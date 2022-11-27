package LinkedList.striver;

public class RotateList {
    public static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null) return head;

        // find the size of list
        Node tail = head;
        int length = 1;
        while(tail.next != null) {
            length++;
            tail = tail.next;
        }

        int remaining = k % length;
        int count = length - remaining;

        Node current = head;
        for(int i = 1; i <= count; i++) {
            current = current.next;
        }

        tail.next = head;
        current.next = null;
        return head;
    }

    public static void main(String[] args) {

    }
}
