package trees.BinaryTrees;

public class LargestSubtreeSumInBinaryTree {
    public static int solve(BinaryTreeNode node, int[] result) {
        if(node == null) return 0;

        int currentSum = node.data + solve(node.left, result) + solve(node.right, result);
        result[0] = Math.max(currentSum, result[0]);
        return  currentSum;
    }

    public static int findLargestSubtreeSum(BinaryTreeNode node) {
        int[] result = {0};
        solve(node, result);
        return result[0];
    }

    public static void main(String[] args) {

    }
}
