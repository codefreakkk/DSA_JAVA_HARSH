package LinkedList;

public class Add1ToNumberRepresentedByLinkedList {
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

    public static Node addOne(Node head) {
        if(head == null) return head;

        Node newHead = reverse(head);

        Node temp = newHead;
        Node dummy = new Node(-1), dHead = dummy;

        int carry = 0;
        int sum = 1;
        int digit = 0;
        int one = 1;
        while(temp != null) {
            sum = temp.value + carry + one;
            carry = sum / 10;
            digit = sum % 10;

            dHead.next = new Node(digit);
            dHead = dHead.next;
            temp = temp.next;
            one = 0;
        }

        if(carry > 0) dHead.next = new Node(carry);
        Node ans = reverse(dummy.next);
        return ans;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(4);
        s.insertLast(5);
        s.insertLast(9);
        Node head = addOne(s.head);
        s.display(head);

    }
}
