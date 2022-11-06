package trees.BinarySearchTrees;

class NodeValue {
    int max, min, size;
    public NodeValue(int max, int min, int size) {
        this.max = max;
        this.min = min;
        this.size = size;
    }
}


public class LargestBSTinBinaryTree {
    public NodeValue solve(TreeNode node) {
        if(node == null) return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        NodeValue left = solve(node.left);
        NodeValue right = solve(node.right);

        if(left.max < node.data && node.data < right.min) {
            return new NodeValue(Math.max(node.data, right.max), Math.min(node.data, left.min), left.size + right.size + 1);
        }

        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.size, right.size));
    }

    public int maxSumBST(TreeNode node) {
        return solve(node).size;
    }

    public static void main(String[] args) {

    }
}
