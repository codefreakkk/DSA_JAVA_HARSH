package trees.codehelp.BinaryTrees;

public class KthAncestorInBinaryTree {
    public BinaryTreeNode solve(BinaryTreeNode node, int[] target, int nodeValue) {
        if(node == null || node.data == nodeValue) return node;

        BinaryTreeNode left = solve(node.left, target, nodeValue);
        BinaryTreeNode right = solve(node.right, target, nodeValue);

        // compute answer
        if(left != null && right == null) {
            target[0]--;
            if(target[0] <= 0) {
                target[0] = Integer.MAX_VALUE;
                return node;
            }
            return left;
        }
        if(right != null && left == null) {
            target[0]--;
            if(target[0] <= 0) {
                target[0] = Integer.MAX_VALUE;
                return node;
            }
            return right;
        }

        return null;
    }

    public int kthAncestor(BinaryTreeNode root, int k, int node) {
        int[] target = {k};
        BinaryTreeNode ans = solve(root, target, node);
        if(ans.data == node) return -1;
        return ans.data;
    }


    public static void main(String[] args) {

    }
}
