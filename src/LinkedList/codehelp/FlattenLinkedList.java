package LinkedList.codehelp;

public class FlattenLinkedList {
    public static Node merge(Node left, Node right) {
        Node prev = left;
        Node leftNext = prev.bottom;
        Node rightNext = right;

        while(leftNext != null && rightNext != null) {
            if(rightNext.value >= prev.value && rightNext.value <= leftNext.value) {
                Node next = rightNext.bottom;
                prev.bottom = rightNext;
                rightNext.bottom = leftNext;

                // update the links
                prev = rightNext;
                rightNext = next;
            }
            else {
                prev = leftNext;
                leftNext = leftNext.bottom;
            }
        }

        if(rightNext != null) prev.bottom = rightNext;
        return left;
    }

    public static Node solve(Node head) {
        if(head == null || head.next == null) return head;

        Node left = head;
        Node right = solve(head.next);

        Node ans = null;
        if(left.value <= right.value) {
            ans = merge(left, right);
        }
        else ans = merge(right, left);

        return ans;
    }

    public static Node flatten(Node head) {
        return solve(head);
    }

    public static void main(String[] args) {

    }
}
