package LinkedList.codehelp;

public class ReverseLinkedListRecursion {
    // 1st approach using recursion
    public static Node reverse1(Node head, Node current, Node prev) {
        if(current == null) return prev;

        Node newHead =  reverse1(head, current.next, current);
        current.next = prev;
        return newHead;
    }
    public static Node reverseList1(Node head) {
        Node current = head, prev = null;
        return reverse1(head, current, prev);
    }


    // 2nd approach using recursion uses only one pointer
    public static Node reverse2(Node head) {
        if(head.next == null || head == null) return head;

        // get the new head
        Node newHead = reverse2(head.next);

        // make connections after coming out from function
        head.next.next = head;
        head.next = null;

        // this new head is only being returned at not been used anywhere
        return newHead;
    }

    public static Node reverseList2(Node head) {
        return reverse2(head);
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(10);
        s.insertLast(20);
        s.insertLast(30);

        s.display();
        Node head = reverseList1(s.head);
        s.display(head);
    }
}
