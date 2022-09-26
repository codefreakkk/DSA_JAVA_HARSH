package LinkedList.codehelp;

import java.util.HashMap;

public class RemoveDuplicatesFromUnsortedList {

    // TC - o(N^2) this solution can give TLE
    public static Node removeDuplicates1(Node head) {
        if(head == null || head.next == null) return head;

        Node current = head;

        while(current != null && current.next != null) {
            Node prev = current;
            Node temp = current.next;

            while(temp != null) {
                if(current.value == temp.value) {
                    prev.next = temp.next;
                    temp = temp.next;
                }
                else {
                    prev = temp;
                    temp = temp.next;
                }
            }

            current = current.next;
        }

        return head;
    }


    // TC - o(N), SC - o(N) this is better solution and work's
    public static Node removeDuplicates(Node head) {
        if(head == null || head.next == null) return head;

        HashMap<Integer, Boolean> map = new HashMap<>();

        Node current = head;
        Node prev = null;

        while(current != null) {
            if(map.containsKey(current.value)) {
                prev.next = current.next;
                current = current.next;
                continue;
            }

            map.put(current.value, true);
            prev = current;
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(2);
        s.insertLast(2);
        s.insertLast(2);
        s.insertLast(2);
        s.display();
        Node head = removeDuplicates(s.head);
        s.display(head);
    }
}
