package trees.BinarySearchTrees;

class Tupple {
    int max, min, sum;
    public Tupple(int max, int min, int sum) {
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
}

public class MaximumSumBSTInBinaryTree {
    public Tupple solve(TreeNode node, int[] result) {
        if (node == null) {
            return new Tupple(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Tupple left = solve(node.left, result);
        Tupple right = solve(node.right, result);
        if (left.max < node.data && node.data < right.min) {
            int sum = left.sum + right.sum + node.data;
            result[0] = Math.max(result[0], sum);
            return new Tupple(Math.max(right.max, node.data), Math.min(left.min, node.data), sum);
        }

        return new Tupple(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }

    public int maxSumBST(TreeNode node) {
        int[] result = {0};
        solve(node, result);
        return result[0];
    }

    public static void main(String[] args) {

    }
}
