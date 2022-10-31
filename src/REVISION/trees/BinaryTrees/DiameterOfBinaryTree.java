package REVISION.trees.BinaryTrees;

public class DiameterOfBinaryTree {
    public int solve(BinaryTreeNode node, int[] max) {
        if(node == null) return 0;

        int left = solve(node.left, max);
        int right = solve(node.right, max);

        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(BinaryTreeNode node) {
        int[] max = new int[1];
        solve(node, max);
        return max[0];
    }

    public static void main(String[] args) {

    }
}
