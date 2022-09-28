package LinkedList.faraz;

public class IntersectionOfTwoLinkedList {
    public static Node getInterSectionOfTwoLinkedList(Node headA, Node headB) {
        Node a = headA;
        Node b = headB;

        while(a != b) {
            if(a == null) a = headB;
            else a = a.next;

            if(b == null) b = headA;
            else b = b.next;
        }

        return a;
    }

    public static void main(String[] args) {

    }
}
