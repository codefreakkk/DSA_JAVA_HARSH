package LinkedList;

public class DeleteAllOccurrencesOfGivenKeyInDLL {
    public static DoublyLinkedListCreation.Node delete(DoublyLinkedListCreation.Node head, DoublyLinkedListCreation.Node current) {
        if(current == head) {
            head = head.next;
            return head;
        }

        if(current.next != null) {
            // set prev connection
            current.next.prev = current.prev;
        }

        if(current.prev != null) {
            // set next connection
            current.prev.next = current.next;
        }

        return head;
    }

    public static DoublyLinkedListCreation.Node deleteAllOccurrences(DoublyLinkedListCreation.Node head, int x) {
        DoublyLinkedListCreation.Node current = head;
        DoublyLinkedListCreation.Node next;
        while(current != null) {
            if(current.value == x) {
                next = current.next;
                head = delete(head, current);
                current = next;
            }
            else current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedListCreation dll = new DoublyLinkedListCreation();
        dll.insertLast(2);
        dll.insertLast(2);
        dll.insertLast(10);
        dll.insertLast(8);
        dll.insertLast(4);
        dll.insertLast(2);
        dll.insertLast(5);
        dll.insertLast(2);

        DoublyLinkedListCreation.Node head = deleteAllOccurrences(dll.head, 2);
        dll.display(head);

    }
}
