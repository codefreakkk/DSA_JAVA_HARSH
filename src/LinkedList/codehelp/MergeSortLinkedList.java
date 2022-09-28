package LinkedList.codehelp;

public class MergeSortLinkedList {
    public static Node getMid(Node head) {
        if(head == null || head.next == null) return head;

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node solve(Node left, Node right) {
        Node prev = left;
        Node leftNext = prev.next;
        Node rightNext = right;

        while(leftNext != null && rightNext != null) {
            if(rightNext.value >= prev.value && rightNext.value <= leftNext.value) {
                // make new connections
                Node next = rightNext.next;
                prev.next = rightNext;
                rightNext.next = leftNext;

                // update connections
                prev = rightNext;
                rightNext = next;
            }
            else {
                prev = leftNext;
                leftNext = leftNext.next;
            }
        }

        if(rightNext != null) prev.next = rightNext;
        return left;
    }

    public static Node merge(Node left, Node right) {
        if(left == null) return right;
        if(right == null) return left;

        if(left.value <= right.value) {
            return solve(left, right);
        }
        else return solve(right, left);
    }

    public static Node mergeSort(Node head) {
        if(head == null || head.next == null) return head;

        Node mid = getMid(head);
        Node newMid = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(newMid);

        return merge(left, right);
    }

    public static Node sorList(Node head) {
        return mergeSort(head);
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(5);
        s.insertLast(4);
        s.insertLast(3);
        s.insertLast(2);
        s.insertLast(1);
        Node head = mergeSort(s.head);
        s.display(head);
    }
}
