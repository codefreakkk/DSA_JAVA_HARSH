package LinkedList.codehelp;

// in place merging without using any extra dummy node
public class MergeTwoSortedList {

    public static Node solve(Node list1, Node list2) {
        Node prev = list1;
        Node current = list1.next;
        Node list2Current = list2;
        Node next2 = null;

        while(current != null && list2Current != null) {
            if(list2Current.value >= prev.value && list2Current.value <= current.value) {
                // make new connections
                prev.next = list2Current;
                next2 = list2Current.next;
                list2Current.next = current;

                // update the pointers
                prev = list2Current;
                list2Current = next2;
            }
            else {
                prev = current;
                current = current.next;
            }
        }

        if(list2Current != null) prev.next = list2Current;
        return list1;
    }

    public static Node mergeTwoList(Node list1, Node list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.value <= list2.value) {
            return solve(list1, list2);
        }
        return solve(list2, list1);
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(4);

        SinglyLinkedListCreation s2 = new SinglyLinkedListCreation();
        s2.insertLast(1);
        s2.insertLast(3);
        s2.insertLast(4);

        Node head = mergeTwoList(s.head, s2.head);
        s.display(head);

    }
}
