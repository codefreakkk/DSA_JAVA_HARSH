package LinkedList;

public class SwapNodesInALinkedList {
    public static Node swapNode(Node head, int k) {
        if(head == null) return head;

        Node dummy = new Node(0);
        Node temp = head;

        // find left k'th node
        for(int i = 0; i < k - 1; i++) temp = temp.next;

        // find right k'th node
        Node slow = head;
        Node fast = head;
        for(int i = 0; i < k - 1; i++) fast = fast.next;

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        int value = temp.value;
        temp.value = slow.value;
        slow.value = value;

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(3);
        s.insertLast(4);
        s.insertLast(5);
        int k = 2;
        Node head = swapNode(s.head, k);
        s.display(head);
    }
}
