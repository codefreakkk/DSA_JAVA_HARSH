package LinkedList.striver;

import java.util.HashMap;

public class CloneLinkedListWithRandomPointer {

    // this is not much optimized TC - o(N), SC - o(N)
    public static Node copyRandomList1(Node head) {
        if(head == null) return head;

        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1), dummyHead = dummy;

        // map the values
        Node temp = head;
        while(temp != null) {
            Node node = new Node(temp.value);
            dummyHead.next = node;
            map.put(temp, node);
            // move pointers
            dummyHead = dummyHead.next;
            temp = temp.next;
        }

        // connect random pointers
        temp = head;
        dummyHead = dummy.next;
        while(temp != null) {
            dummyHead.random = map.get(temp.random);
            temp = temp.next;
            dummyHead = dummyHead.next;
        }

        return dummy.next;
    }

    // optimized problem
    public static Node copyRandomList(Node head) {
        if(head == null) return head;

        Node dummy = new Node(-1);
        Node original = head;
        Node clone = dummy;

        // make clone node
        while(original != null) {
            clone.next = new Node(original.value);
            original = original.next;
            clone = clone.next;
        }

        // change the links
        original = head;
        clone = dummy.next;
        while(original != null && clone != null) {
            Node next = original.next;
            original.next = clone;
            original = next;

            next = clone.next;
            clone.next = original;
            clone = next;
        }

        // map random values
        original = head;
        while(original != null) {
            if(original.next != null && original.random != null) {
                original.next.random = original.random.next;
            }
            original = original.next.next;
        }

        // reset the links
        original = head;
        clone = dummy.next;
        while(original != null && clone != null) {
            // reset original node connection
            original.next = clone.next;
            original = original.next;

            // reset clone node connection
            if(original != null) {
                clone.next = original.next;
            }
            clone = clone.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
