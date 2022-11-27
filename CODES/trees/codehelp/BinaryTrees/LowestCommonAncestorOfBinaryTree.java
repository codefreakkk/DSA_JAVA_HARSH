package trees.codehelp.BinaryTrees;

public class LowestCommonAncestorOfBinaryTree {
    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode node, BinaryTreeNode p, BinaryTreeNode q) {
        if(node == null) return null;

        BinaryTreeNode left = lowestCommonAncestor(node.left, p, q);
        BinaryTreeNode right = lowestCommonAncestor(node.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return node;
    }

    public static void main(String[] args) {

    }
}
