package trees.codehelp.BinarySearchTrees;

public class DeleteANodeInBST {

    public TreeNode deleteNode(TreeNode node, int val) {
        if (node == null) {
            return node;
        }
        if (node.data == val) {
            return helper(node);
        }

        TreeNode current = node;
        while (current != null) {
            if (val < current.data) {
                if (current.left != null && current.left.data == val) {
                    current.left = helper(current.left);
                } else
                    current = current.left;
            } else {
                if (current.right != null && current.right.data == val) {
                    current.right = helper(current.right);
                } else
                    current = current.right;
            }
        }
        return node;
    }

    public TreeNode helper(TreeNode node) {
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;

        TreeNode last = findLastNode(node.left);
        last.right = node.right;
        return node.left;
    }

    public TreeNode findLastNode(TreeNode node) {
        while (node.right != null)
            node = node.right;
        return node;
    }

    public static void main(String[] args) {
    }
}
