package LinkedList.striver;

public class IntersectionPointOfTwoLinkedList {

    public static Node getIntersectionNode(Node headA, Node headB) {
        Node head1 = headA;
        Node head2 = headB;

        int count1 = 0, count2 = 0;
        while(head1 != null || head2 != null) {
            if(head1 != null) {
                count1++;
                head1 = head1.next;
            }
            if(head2 != null) {
                count2++;
                head2 = head2.next;
            }
        }

        head1 = headA;
        head2 = headB;
        int small = 0;
        if(count1 <= count2) {
            small = count2 - count1;
            while(small > 0) {
                head2 = head2.next;
                small--;
            }
        }
        else {
            small = count1 - count2;
            while(small > 0) {
                head1 = head1.next;
                small--;
            }
        }

        while(head1 != null && head2 != null) {
            if(head1 == head2) return head1;
            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
