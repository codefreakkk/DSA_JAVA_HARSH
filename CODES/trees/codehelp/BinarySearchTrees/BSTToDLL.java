package trees.codehelp.BinarySearchTrees;

public class BSTToDLL {
    
    TreeNode head = null;
    public void solve(TreeNode root) {
        if (root == null)
            return;

        solve(root.right);
        root.right = head;

        if (head != null)
            head.left = root;

        head = root;
        solve(root.left);
    }

    public TreeNode bstToDLL(TreeNode root) {
        solve(root);
        return head;
    }

    public static void main(String[] args) {}
}
