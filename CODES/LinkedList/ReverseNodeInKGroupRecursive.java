package LinkedList;

public class ReverseNodeInKGroupRecursive {

    // TC : o(N) , SC : o(N/K)

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

    public static Node reverseKGroup(Node head, int k) {
        if(head == null || head.next == null || k == 1) return head;

        Node start = head;
        Node end = head;

        // move k - 1 steps
        for(int i = 0; i < k - 1; i++) {
            end = end.next;
            if(end == null) return head;
        }

        Node nextHead = reverseKGroup(end.next, k);
        // reverse list after coming out from recursion
        reverse(start, end);
        start.next = nextHead;
        return end;
    }

    public static void main(String[] args) {
    }
}
