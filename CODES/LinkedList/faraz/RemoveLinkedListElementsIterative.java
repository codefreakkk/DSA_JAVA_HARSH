package LinkedList.faraz;

public class RemoveLinkedListElementsIterative {
    public static Node removeElements(Node head, int val) {
        if(head == null || head.next == null) return head;

        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;

        while(current != null) {
            if(current.value != val) {
                prev = current;
                current = current.next;
            }
            else {
                while(current.next != null && current.next.value == val) {
                    current = current.next;
                }

                prev.next = current.next;
                current = prev.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation l = new SinglyLinkedListCreation();
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(6);
        l.insertLast(3);
        l.insertLast(4);
        l.insertLast(5);
        l.insertLast(6);

        int val = 6;
        Node head = removeElements(l.head, val);
        l.display(head);
    }
}
