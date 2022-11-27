package REVISION.trees.BinaryTrees;

public class BalancedBinaryTree {
    public int solve(BinaryTreeNode node) {
        if(node == null) return 0;

        int left = solve(node.left);
        int right = solve(node.right);

        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(BinaryTreeNode node) {
        if(node == null) return true;
        return solve(node) == -1 ? false : true;
    }

    public static void main(String[] args) {

    }
}
