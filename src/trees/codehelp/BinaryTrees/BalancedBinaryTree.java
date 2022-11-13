package trees.codehelp.BinaryTrees;

public class BalancedBinaryTree {
    public int solve(BinaryTreeNode node) {
        if(node == null) return 0;

        int left = solve(node.left);
        int right = solve(node.right);

        if(Math.abs(left - right) > 1) return -1;
        if(left == -1 || right == -1) return -1;

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(BinaryTreeNode node) {
        int ans = solve(node);
        return ans == -1 ? false : true;
    }

    public static void main(String[] args) {

    }
}
