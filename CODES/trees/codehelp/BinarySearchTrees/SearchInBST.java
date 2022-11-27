package trees.codehelp.BinarySearchTrees;

public class SearchInBST {

    // Approacch 1
    // TC - o(LogN) sc - o(H) not much optimized
    public TreeNode solve(TreeNode node, int val) {
        if (node == null)
            return null;
        if (node.data == val)
            return node;

        if (val < node.data)
            return solve(node.left, val);
        else
            return solve(node.right, val);
    }

    public TreeNode searchInBSTUsingRecursion(TreeNode node, int val) {
        TreeNode root = solve(node, val);
        return root;
    }

    // Approach 2
    // TC - o(LogN) sc - o(1) optimized approach
    public TreeNode searchInBST(TreeNode node, int val) {
        TreeNode current = node;
        while (current != null) {
            if (current.data == val) 
                return current;
            if (val < current.data)
                current = current.left;
            else 
                current = current.right;
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
