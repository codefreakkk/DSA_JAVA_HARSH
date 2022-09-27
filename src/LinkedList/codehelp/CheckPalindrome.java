package LinkedList.codehelp;

public class CheckPalindrome {
    public static Node reverse(Node start, Node end) {
        Node prev = null;
        Node present = start;
        Node nxt = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = nxt;
            if(nxt != null) nxt = nxt.next;
        }

        return prev;
    }

    public static Node getTail(Node head) {
        Node temp = head;
        while(temp.next != null) temp = temp.next;

        return temp;
    }

    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) return true;

        Node start = head;
        Node tail = getTail(head);
        Node mid = getMid(head);

        Node newStart = reverse(mid.next, tail);

        // compare elements
        while(newStart != null) {
            if(start.value != newStart.value) return false;
            start = start.next;
            newStart = newStart.next;
        }

        return true;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(1);
//        s.insertLast(2);
//        s.insertLast(3);
//        s.insertLast(2);
//        s.insertLast(1);
        System.out.println(isPalindrome(s.head));
    }
}
