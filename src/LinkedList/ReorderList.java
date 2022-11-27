package LinkedList;

public class ReorderList {
    public static Node getMid(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static Node reverse(Node head) {
        if(head == null || head.next == null) return null;

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

    public static void reorderList(Node head) {
        Node mid = getMid(head);
        Node secondHead = reverse(mid);
        Node firstHead = head;

        while(head != null && firstHead != null) {
            // handle arrangement from first head
            Node temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;

            // handle arrangement from second head
            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }

        if(firstHead != null) firstHead.next = null;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation sl = new SinglyLinkedListCreation();
        sl.insertLast(1);
        sl.insertLast(2);
        sl.insertLast(3);
//        sl.insertLast(4);
//        sl.insertLast(5);
        reorderList(sl.head);
        sl.display();
    }
}
