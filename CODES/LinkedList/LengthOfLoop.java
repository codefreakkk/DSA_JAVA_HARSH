package LinkedList;

public class LengthOfLoop {
    public static Node getIntersection(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static int countNodesInLoop(Node head) {
        Node intersection = getIntersection(head);
        Node temp = intersection;

        if(intersection == null) return 0;

        int count = 0;
        while(temp.next != intersection) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
