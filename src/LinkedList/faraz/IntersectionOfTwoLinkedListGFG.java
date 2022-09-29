package LinkedList.faraz;

import java.util.*;

public class IntersectionOfTwoLinkedListGFG {
    public static Node findIntersection(Node headA, Node headB) {
        HashSet<Integer> set = new HashSet<>();
        Node temp = headB;

        // put all the values in map
        while(temp != null) {
            set.add(temp.value);
            temp = temp.next;
        }

        // generate ans list
        Node dummy = new Node(-1), ansHead = dummy;
        while(headA != null) {
            if(set.contains(headA.value)) {
                ansHead.next = new Node(headA.value);
                ansHead = ansHead.next;
            }

            headA = headA.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
