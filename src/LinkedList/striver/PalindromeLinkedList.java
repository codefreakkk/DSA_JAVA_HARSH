package LinkedList.striver;

public class PalindromeLinkedList {
    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node present = head;
        Node nxt = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = nxt;
            if(nxt != null) nxt = nxt.next;
        }

        return prev;
    }

    public static boolean isPalindrome(Node head) {
        if(head == null) return false;

        Node mid = getMid(head);
        Node secondHead = reverse(mid.next);
        Node firstHead = head;

        while(secondHead != null) {
            if(firstHead.value != secondHead.value) return false;
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
