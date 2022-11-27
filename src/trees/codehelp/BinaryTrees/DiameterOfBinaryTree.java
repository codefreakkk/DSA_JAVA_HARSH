package trees.codehelp.BinaryTrees;

public class DiameterOfBinaryTree {
    public int solve(BinaryTreeNode node, int[] maxi) {
        if(node == null) return 0;

        int left = solve(node.left, maxi);
        int right = solve(node.right, maxi);

        maxi[0] = Math.max(maxi[0], left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(BinaryTreeNode node) {
        int[] maxi = {0};
        solve(node, maxi);
        return maxi[0];
    }
    public static void main(String[] args) {

    }
}
