package LinkedList;


//----------------------------problem not solved yetttt-------------------------------


public class ReverseADoublyLinkedListInGroupOfGivenSize {

    public static DoublyLinkedListCreation.Node reverse(DoublyLinkedListCreation.Node start, DoublyLinkedListCreation.Node end) {
        DoublyLinkedListCreation.Node current = end;

        // reverse end node first
        current.next = current.prev;
        current.prev = null;
        current = current.next;

        // reverse all middle nodes
        while(current.prev != null) {
            DoublyLinkedListCreation.Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = current.next;
        }

        // reverse first node
        current.prev = current.next;
        current.next = null;

        return end;
    }
    public static DoublyLinkedListCreation.Node reverseInGroupOfGivenSize(DoublyLinkedListCreation.Node head, int k) {
        DoublyLinkedListCreation.Node start = head;
        DoublyLinkedListCreation.Node end = head;

        DoublyLinkedListCreation.Node dummy = new DoublyLinkedListCreation.Node(1);
        DoublyLinkedListCreation.Node beforeStart = dummy;
        dummy.next = head;

        int i = 0;
        while(end.next != null) {
            i++;
            if(i % k == 0) {
                DoublyLinkedListCreation.Node temp = end.next;
                reverse(start, end);

                beforeStart.next = end;
                end.prev = beforeStart;

                start.next = temp;
                temp.prev = start;

                beforeStart = start;
                end = temp;
                start = temp;
            }
            else end = end.next;
        }

        reverse(start, end);
        beforeStart.next = end;
        end.prev = beforeStart;
        dummy = dummy.next;
        return dummy;
    }

    public static void main(String[] args) {
        DoublyLinkedListCreation dll = new DoublyLinkedListCreation();
        dll.insertLast(10);
        dll.insertLast(8);
        dll.insertLast(4);
        dll.insertLast(2);
        DoublyLinkedListCreation.Node head = reverseInGroupOfGivenSize(dll.head, 2);
        dll.display(head);
    }
}
