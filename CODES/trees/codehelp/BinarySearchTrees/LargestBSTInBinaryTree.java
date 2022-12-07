package trees.codehelp.BinarySearchTrees;

class Tupple {
    int size, max, min;

    public Tupple(int max, int min, int size) {
        this.max = max;
        this.min = min;
        this.size = size;
    }
}

public class LargestBSTInBinaryTree {
    public Tupple solve(TreeNode root) {
        if (root == null) {
            return new Tupple(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Tupple left = solve(root.left);
        Tupple right = solve(root.right);

        if (left.max < root.data && root.data < right.min) {
            return new Tupple(Math.max(root.data, right.max), Math.min(root.data, left.min),
                    left.size + right.size + 1);
        }
        return new Tupple(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.size, right.size));
    }

    public int maxSumBST(TreeNode root) {
        return solve(root).size;
    }

    public static void main(String[] args) {
    }
}
