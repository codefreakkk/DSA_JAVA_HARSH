package trees;

public class MinimumDepthOfTreeDFS {
    public static int minDepth(BinaryTreeNode node) {
        if(node == null) return 0;

        int left = minDepth(node.left);
        int right = minDepth(node.right);

        return (left == 0 || right == 0) ? left + right + 1 : 1 + Math.min(left, right);
    }

    public static void main(String[] args) {

    }
}
