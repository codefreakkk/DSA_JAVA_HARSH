package LinkedList;

public class RemoveDuplicatesFromSortedDoublyLinkedList {

    public static DoublyLinkedListCreation.Node removeDuplicates(DoublyLinkedListCreation.Node head) {
        if(head == null) return head;

        DoublyLinkedListCreation.Node temp = head;
        while(temp.next != null) {
            if(temp.value == temp.next.value) {
                temp.next = temp.next.next;
            }
            else {
                DoublyLinkedListCreation.Node nxt = temp.next;
                nxt.prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedListCreation dll = new DoublyLinkedListCreation();
        dll.insertLast(4);
        dll.insertLast(4);
        dll.insertLast(4);
        dll.insertLast(4);
        dll.insertLast(6);
        dll.insertLast(8);
        dll.insertLast(8);
        dll.insertLast(10);
        dll.insertLast(12);
        dll.insertLast(12);
        DoublyLinkedListCreation.Node head = removeDuplicates(dll.head);
        dll.display(head);
    }
}
