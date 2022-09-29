package LinkedList.faraz;

public class PalindromeLinkedList  {
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
        if(head == null || head.next == null) return true;

        Node temp = head;
        Node mid = getMid(head);
        Node newHead = reverse(mid.next);

        while(newHead != null) {
            if(temp.value != newHead.value) return false;
            newHead = newHead.next;
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation l = new SinglyLinkedListCreation();
        l.insertLast(1);
        l.insertLast(0);
        l.insertLast(11);
        System.out.println(isPalindrome(l.head));
    }
}
