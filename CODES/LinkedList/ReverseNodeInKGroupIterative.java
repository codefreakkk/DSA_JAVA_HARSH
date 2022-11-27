package LinkedList;

public class ReverseNodeInKGroupIterative {
    public static void reverse(Node start, Node end) {
        Node prev = null, present = start, nxt = present.next;

        while(prev != end) {
            present.next = prev;
            prev = present;
            present = nxt;
            if(nxt != null) nxt = nxt.next;
        }
    }

    public static Node reverseKGroup(Node head, int k) {
        if(head == null || head.next == null || k == 1) return head;

        Node dummy = new Node(-1);
        dummy.next = head;
        Node beforeStart = dummy, end = head;

        int i = 0;
        while(end != null) {
            i++;

            if(i % k == 0) {
                // do reverse operation of the group
                Node start = beforeStart.next;
                // store the next right side first node other than the group
                Node temp = end.next;
                reverse(start, end);
                // make the connection with first node of group
                beforeStart.next = end;
                // make the last connection of node with the first right side node
                start.next = temp;
                // update the previous variable
                beforeStart = start;
                // update end
                end = temp;
            }
            else end = end.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(3);
        s.insertLast(4);
        s.insertLast(5);
        int k = 2;
        Node head = reverseKGroup(s.head, k);
        s.display(head);
    }
}
