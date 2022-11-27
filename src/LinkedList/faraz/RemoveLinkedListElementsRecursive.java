package LinkedList.faraz;

public class RemoveLinkedListElementsRecursive {
    public static Node solve(Node head, int val) {
        if(head == null) return head;

        Node back = solve(head.next, val);
        if(head.value != val) {
            head.next = back;
            return head;
        }
        else return back;
    }

    public static Node removeElements(Node head, int val) {
        if(head == null) return head;
        return solve(head, val);
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation l = new SinglyLinkedListCreation();
        l.insertLast(7);
        l.insertLast(7);
        l.insertLast(7);
        l.insertLast(7);
//        l.insertLast(4);
//        l.insertLast(5);
//        l.insertLast(6);
        int val = 7;

        Node head = removeElements(l.head, val);
        l.display(head);
    }
}
