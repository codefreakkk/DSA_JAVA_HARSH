package REVISION.trees.BinaryTrees;

public class MaximumPathSumInBinaryTree {
    public int solve(BinaryTreeNode node, int[] max) {
        if(node == null) return 0;

        int left = Math.max(solve(node.left, max), 0);
        int right = Math.max(solve(node.right, max), 0);

        max[0] = Math.max(max[0], left + right + node.data);
        return Math.max(left, right) + node.data;
    }

    public int maxPathSum(BinaryTreeNode node) {
        int[] max = new int[1];
        solve(node, max);
        return max[0];
    }

    public static void main(String[] args) {

    }
}
