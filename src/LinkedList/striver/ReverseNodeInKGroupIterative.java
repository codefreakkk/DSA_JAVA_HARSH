package LinkedList.striver;

import static LinkedList.striver.ReverseNodeInKGroupRecursive.reverse;

public class ReverseNodeInKGroupIterative {
    public static Node reverseKGroup(Node head, int k) {
        if(head == null || head.next == null) return head;

        Node dummy = new Node(-1), prev = dummy;
        prev.next = head;

        Node start = head;
        Node end = head;

        int i = 0;
        while(end != null) {
            i++;
            if(i % k == 0) {
                start = prev.next;
                Node temp = end.next;
                reverse(start, end);
                prev.next = end;
                start.next = temp;
                prev = start;
                end = temp;
            }
            else end = end.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
