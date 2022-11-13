package trees.codehelp.BinaryTrees;

public class MaximumHeightOfBinaryTree {
    public int height(BinaryTreeNode node) {
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

    }
}
