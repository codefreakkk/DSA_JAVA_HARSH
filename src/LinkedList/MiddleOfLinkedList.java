package LinkedList;

public class MiddleOfLinkedList {
    public static Node middleNode(Node node) {
        if(node == null || node.next == null) return node;

        Node fast = node;
        Node slow = node;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {

    }
}
