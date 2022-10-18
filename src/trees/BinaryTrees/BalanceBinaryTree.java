package trees.BinaryTrees;

public class BalanceBinaryTree {
    public int solve(BinaryTreeNode node) {
        if(node == null) return 0;

        int left = solve(node.left);
        int right = solve(node.right);

        if(Math.abs(right - left) > 1) return -1;
        if(left == -1 || right == -1) return -1;

        return Math.max(left, right) + 1;
    }

    public boolean checkBalanceBinaryTree(BinaryTreeNode node) {
        if(node == null) return true;
        return solve(node) != -1;
    }

    public static void main(String[] args) {

    }
}
