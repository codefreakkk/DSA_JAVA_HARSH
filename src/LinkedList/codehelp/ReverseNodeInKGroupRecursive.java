package LinkedList.codehelp;

// this solution is slightly different from leetcode's solution
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
    public static Node reverseNode(Node head, int k) {
        // base case
        if(head == null || head.next == null || k == 1) return head;

        Node start = head;
        Node end = head;

        // traverse till window size
        for(int i = 0; end.next != null &&  i < k - 1; i++) {
            end = end.next;
        }

        Node node = reverseNode(end.next, k);
        reverse(start, end);
        start.next = node;

        return end;
    }

    public static Node reverseInKGroup(Node head, int k) {
        return reverseNode(head, k);
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
        Node head = reverseInKGroup(s.head, k);
        s.display(head);
    }
}
