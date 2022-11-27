package LinkedList;

public class ReverseDoublyLinkedList {
    public static Node reverseDll(Node head) {
        Node current = head;

        // base case
        if(current == null || current.next == null) return current;

        // traverse till end of list first
        while(current.next != null) {
            current = current.next;
        }
        head = current;

        // handle last node
        current.next = current.prev;
        current.prev = null;
        current = current.next;

        // handle middle nodes
        while(current.prev != null) {
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = current.next;
        }

        // handle first node
        current.prev = current.next;
        current.next = null;

        return head;
    }
    public static void main(String[] args) {

    }
}
