package trees;

public class MaximumPathSumInBinaryTree {
    public int solve(BinaryTreeNode node, int[] sum) {
        if(node == null) return 0;

        int left = Math.max(solve(node.left, sum), 0);
        int right = Math.max(solve(node.right, sum), 0);

        sum[0] = Math.max(sum[0], left + right + node.data);
        return node.data + Math.max(left, right);
    }

    public int maxPathSum(BinaryTreeNode node) {
        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
        solve(node, sum);
        return sum[0];
    }

    public static void main(String[] args) {

    }
}
