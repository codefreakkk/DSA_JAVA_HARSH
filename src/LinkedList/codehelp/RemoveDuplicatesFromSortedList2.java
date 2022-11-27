package LinkedList.codehelp;

public class RemoveDuplicatesFromSortedList2 {
    public static Node deleteDuplicates(Node head) {
        if(head == null || head.next == null) return head;

        Node temp = new Node(0, head);
        Node dummy = temp;

        Node current = head;

        while(current != null && current.next != null) {
            if(current.value != current.next.value) {
                temp = current;
                current = current.next;
            }
            else {
                // move current forward
                while(current.next != null && current.value == current.next.value) {
                    current = current.next;
                }
                temp.next = current.next;
                current = temp.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(1);
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(3);
//        s.insertLast(4);
//        s.insertLast(5);
        s.display();
        Node head = deleteDuplicates(s.head);
        s.display(head);
    }
}
