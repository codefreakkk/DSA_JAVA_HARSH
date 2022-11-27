package LinkedList;

public class SegregateEvenAndOddNodesInLinkedList {
    public static Node divide(int n, Node head) {
        Node odd = new Node(-1), oddHead = odd;
        Node even = new Node(-1), evenHead = even;
        Node temp = head;

        while(temp != null) {
            if(temp.value % 2 != 0) {
                oddHead.next = temp;
                oddHead = oddHead.next;
            }
            else {
                evenHead.next = temp;
                evenHead = evenHead.next;
            }
            temp = temp.next;
        }

        if(odd.next == null) return even.next;
        if(even.next == null) return odd.next;
        evenHead.next = odd.next;
        oddHead.next = null;

        return even.next;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(17);
        s.insertLast(15);
        s.insertLast(8);
        s.insertLast(9);
        s.insertLast(2);
        s.insertLast(4);
        s.insertLast(6);
        Node head = divide(7, s.head);
        s.display(head);
    }
}
