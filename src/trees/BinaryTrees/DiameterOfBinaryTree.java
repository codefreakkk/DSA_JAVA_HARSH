package trees.BinaryTrees;

public class DiameterOfBinaryTree {
    public int solve(BinaryTreeNode node, int[] maxi) {
        if(node == null) return 0;

        int left = solve(node.left, maxi);
        int right = solve(node.right,maxi);

        // find maximum value
        maxi[0] = Math.max(maxi[0], left + right);
        return  1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(BinaryTreeNode node) {
        int[] maxi = new int[1];
        solve(node, maxi);
        return maxi[0];
    }

    public static void main(String[] args) {

    }
}
