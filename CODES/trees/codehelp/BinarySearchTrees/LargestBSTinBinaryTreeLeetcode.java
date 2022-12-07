package trees.codehelp.BinarySearchTrees;

class Tupple {
    int size, max, min;

    public Tupple(int max, int min, int size) {
        this.max = max;
        this.min = min;
        this.size = size;
    }
}

public class LargestBSTinBinaryTreeLeetcode {

    public Tupple solve(TreeNode root, int[] result) {
        if (root == null) {
            return new Tupple(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Tupple left = solve(root.left, result);
        Tupple right = solve(root.right, result);

        if (left.max < root.data && root.data < right.min) {
            int sum = left.size + right.size + root.data;
            result[0] = Math.max(result[0], sum);
            return new Tupple(Math.max(root.data, right.max), Math.min(root.data, left.min), sum);
        }
        return new Tupple(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }

    public int maxSumBST(TreeNode root) {
        int[] result = {0};
        solve(root, result);
        return result[0];
    }
    
    public static void main(String[] args) {

    }
}
