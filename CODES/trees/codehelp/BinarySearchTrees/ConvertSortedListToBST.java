package trees.codehelp.BinarySearchTrees;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.next = null;
    }
}

public class ConvertSortedListToBST {

    public ListNode getMidNode(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public TreeNode solve(ListNode head, ListNode tail) {
        if (head == tail)
            return null;

        ListNode mid = getMidNode(head, tail);
        TreeNode root = new TreeNode(mid.val);

        root.left = solve(head, mid);
        root.right = solve(mid.next, tail);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = solve(head, null);
        return root;
    }

    public static void main(String[] args) {
    }
}
