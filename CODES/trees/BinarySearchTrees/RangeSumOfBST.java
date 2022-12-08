package trees.BinarySearchTrees;

public class RangeSumOfBST {
    public int rangeSum(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.data >= low && root.data <= high)
            sum += root.data;

        int left = rangeSum(root.left, low, high);
        int right = rangeSum(root.right, low, high);
        return sum + left + right;
    }

    public static void main(String[] args) {

    }
}
