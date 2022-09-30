package LinkedList.striver;

public class ReverseNodeInKGroupRecursive {

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

    public static Node solve(Node head, int n) {
        if(head == null || head.next == null) return head;

        Node start = head;
        Node end = head;

        // move end to window size
        for(int i = 0; i < n - 1; i++) {
            if(end == null) return head;
            end = end.next;
        }

        Node back = solve(end.next, n);
        reverse(start, end);
        start.next = back;
        return end;
    }

    public static Node reverseKGroup(Node head, int n) {
        return solve(head, n);
    }

    public static void main(String[] args) {

    }
}
