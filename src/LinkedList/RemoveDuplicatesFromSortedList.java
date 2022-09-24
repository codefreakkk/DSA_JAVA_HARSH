package LinkedList;

public class RemoveDuplicatesFromSortedList extends SinglyLinkedListCreation {

    // recursive way by harsh
    public Node removeDuplicates(Node node) {
        if(node.next == null) {
            return node;
        }

        Node n = removeDuplicates(node.next);
        if(node.value != n.value) {
            node.next = n;
            return node;
        }
        else return n;
    }
    public Node deleteDuplicates(Node head) {
        head = removeDuplicates(head);
        return head;
    }


    // iterative way
    public void removeDuplicatesFromList(Node head) {
        Node node = head;
        while(node.next != null) {
            if(node.value == node.next.value) {
                node.next = node.next.next;
            }
            else node = node.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList ll = new RemoveDuplicatesFromSortedList();
        ll.insertLast(1);
        ll.insertLast(1);
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(4);
        ll.insertLast(4);
//        ll.head = ll.deleteDuplicates(ll.head);
        ll.removeDuplicatesFromList(ll.head);
        ll.display();
    }
}
