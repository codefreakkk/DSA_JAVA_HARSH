package LinkedList.codehelp;

public class PositionOfLoop {
    public Node hasCycle(Node head) {

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

    public Node detectCycle(Node head) {

        Node intersection = this.hasCycle(head);
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

    public static void main(String[] args) {
    }
}
