package trees.BinarySearchTrees;

public class CheckIfTreeIsBSTorBT {
    public boolean solve(TreeNode node, long min, long max) {
        if(node == null) return true;
        if(!(node.data > min && node.data < max)) return false;

        boolean left = solve(node.left, min, node.data);
        boolean right = solve(node.right, node.data, max);

        return left && right;
    }

    public boolean validate(TreeNode node) {
        return solve(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {

    }
}
