package trees.BinaryTrees;

public class MaximumDepthOfBinaryTreeDFS {
    public static int maxDepth(BinaryTreeNode node) {
        if(node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        return 1 + Math.max(left,right);
    }

    public static void main(String[] args) {

    }
}
