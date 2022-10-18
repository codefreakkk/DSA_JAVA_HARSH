package trees.BinaryTrees;

public class LowestCommonAncestorsOfBinaryTree {
    public BinaryTreeNode lowestCommonAncestorsOfBinaryTree(BinaryTreeNode node, BinaryTreeNode p, BinaryTreeNode q) {
        if(node == null || node == p || node == q) return node;

        BinaryTreeNode left = lowestCommonAncestorsOfBinaryTree(node.left, p, q);
        BinaryTreeNode right = lowestCommonAncestorsOfBinaryTree(node.right, p, q);

        // if any of node is null then return its opposite node
        if(left == null) return right;
        if(right == null) return left;

        // if right and left are not null then ans found;
        return node;
    }

}
