package LinkedList.codehelp;

// this solution is slightly different from leetcode's solution

public class ReverseNodeInKGroupIterative {
    public static void reverse(Node start, Node end) {
        Node prev = null;
        Node present = start;
        Node nxt = present.next;

        while(prev != end) {
            present.next = prev;
            prev = present;
            present = nxt;
            if(nxt != null) nxt = nxt.next;
        }
    }

    public static Node reverseNodeInKGroup(Node head, int k) {
        if(head == null || head.next == null || k == 1) return head;

        Node dummy = new Node(-1);
        dummy.next = head;
        Node beforeStart = dummy;

        Node end = head;
        Node start = head;

        int i = 0;
        while(end.next != null) {
            i++;

            if(i % k == 0) {
                Node temp = end.next;
                reverse(start, end);
                // update dummy's next
                beforeStart.next = end;
                start.next = temp;
                beforeStart = start;
                end = temp;
                start = temp;
            }
            else end = end.next;
        }

        // reverse remaining group
        reverse(start, end);
        beforeStart.next = end;
        start.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(2);
        s.insertLast(4);
        s.insertLast(5);
        s.insertLast(6);
        s.insertLast(7);
        s.insertLast(8);
        int k = 4;

        s.display();
        Node head = reverseNodeInKGroup(s.head, k);
        s.display(head);
    }
}
