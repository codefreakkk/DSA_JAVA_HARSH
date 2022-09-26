package LinkedList.codehelp;

public class RemoveLoop {
    public static Node hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(slow != null && fast != null) {
            fast = fast.next;
            if(fast != null) fast = fast.next;

            slow = slow.next;

            if(slow == fast) return slow;
        }

        return null;
    }

    public static Node getStartingNode(Node head) {
        Node intersection = hasCycle(head);
        if(intersection != null) {
            Node slow = head;
            Node fast = intersection;

            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }

        return null;
    }

    public static void removeLoop(Node head) {
        if(head == null) return;

        Node starting = getStartingNode(head);
        if(starting != null) {
            Node temp = starting;

            while(temp.next != starting) temp = temp.next;
            temp.next = null;
        }
    }

    public static void main(String[] args) {

    }
}
