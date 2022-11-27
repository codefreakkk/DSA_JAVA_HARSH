package trees.codehelp.BinaryTrees;

public class FlattenABinaryTree {
    public void flatten(BinaryTreeNode node) {
        BinaryTreeNode current = node;
        while (current != null) {
            if (current.left != null) {
                BinaryTreeNode prev = current.left;
                while (prev.right != null)
                    prev = prev.right;
                prev.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    public static void main(String[] args) {
    }
}
