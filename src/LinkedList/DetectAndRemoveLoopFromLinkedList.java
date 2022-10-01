package LinkedList;

public class DetectAndRemoveLoopFromLinkedList {
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

    public static Node getIntersection(Node head) {
        Node fast = hasCycle(head);
        if(fast != null) {
            Node slow = head;
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

        Node intersection = getIntersection(head);
        if(intersection == null) return;

        Node temp = intersection;
        while(temp.next != intersection) temp = temp.next;
        temp.next = null;
    }

    public static void main(String[] args) {

    }
}
