package LinkedList;

public class OddEvenLinkedList {
    // approach 1
    public static Node oddEvenList1(Node head) {
        if(head == null) return head;

        Node odd = new Node(0), oddTail = odd;
        Node even = new Node(0), evenHead = even;

        Node temp = head;
        int count = 1;
        while(temp != null) {
            if(count % 2 == 1) {
                oddTail.next = temp;
                oddTail = oddTail.next;
            }
            else {
                evenHead.next = temp;
                evenHead = evenHead.next;
            }

            temp = temp.next;
            count++;
        }

        evenHead.next = null;
        oddTail.next = even.next;

        return odd.next;
    }

    // approach 2 in place
    public static Node oddEvenList(Node head) {
        if(head == null) return head;
        if(head.next == null) return head;

        Node oddHead = head;
        Node evenHead = head.next;

        Node odd = oddHead, even = evenHead;
        while(evenHead != null && evenHead.next != null) {
            oddHead.next = oddHead.next.next;
            oddHead = oddHead.next;

            evenHead.next = evenHead.next.next;
            evenHead = evenHead.next;
        }

        oddHead.next = even;
        return odd;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(2);
        s.insertLast(1);
        s.insertLast(3);
        s.insertLast(5);
        s.insertLast(6);
        s.insertLast(4);
        s.insertLast(7);
        Node head = oddEvenList(s.head);
        s.display(head);
    }
}
