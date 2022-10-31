package REVISION.trees.BinaryTrees;

public class MaximumDepthOfBinaryTreeDFS {
    public int maxDepth(BinaryTreeNode node) {
        if(node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

    }
}
