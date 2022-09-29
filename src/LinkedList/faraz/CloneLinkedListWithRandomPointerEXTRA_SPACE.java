package LinkedList.faraz;

import java.util.HashMap;

public class CloneLinkedListWithRandomPointerEXTRA_SPACE {

    public Node copyList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1), dummyHead = dummy;

        // clone linked list without random pointer
        Node temp = head;
        while(temp != null) {
            dummyHead.next = new Node(temp.value);
            map.put(temp, dummyHead.next);
            dummyHead = dummyHead.next;
            temp = temp.next;
        }

        // make random pointer connections
        dummyHead = dummy.next;
        temp = head;

        while(temp != null) {
            dummyHead.random = map.get(temp.random);
            temp = temp.next;
            dummyHead = dummyHead.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
