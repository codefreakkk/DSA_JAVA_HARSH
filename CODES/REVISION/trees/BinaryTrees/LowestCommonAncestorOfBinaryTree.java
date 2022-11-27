package REVISION.trees.BinaryTrees;

public class LowestCommonAncestorOfBinaryTree {
    public BinaryTreeNode lca(BinaryTreeNode node, BinaryTreeNode p, BinaryTreeNode q) {
        if(node == null || node == p || node == q) return node;

        BinaryTreeNode left = lca(node.left, p, q);
        BinaryTreeNode right = lca(node.right, p, q);

        if(left == null) return right;
        if(right == null) return left;
        return node;
    }

    public static void main(String[] args) {

    }
}
