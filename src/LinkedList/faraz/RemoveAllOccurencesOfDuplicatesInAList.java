package LinkedList.faraz;

public class RemoveAllOccurencesOfDuplicatesInAList {
    public static Node removeAllDuplicates(Node head) {
        if(head == null || head.next == null) return head;

        Node dummy = new Node(-1, head);
        Node temp = dummy;
        Node current = head;

        while(current != null && current.next != null) {
            if(current.value != current.next.value) {
                temp = current;
                current = current.next;
            }
            else {
                // move current until it reaches last element of duplicate
                while(current.next != null && current.value == current.next.value) {
                    current = current.next;
                }

                // make connections of nodes
                temp.next = current.next;
                current = temp.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(3);
        s.insertLast(3);
        s.insertLast(4);
        s.insertLast(4);
        s.insertLast(5);
        Node head = removeAllDuplicates(s.head);
        s.display(head);

    }
}
