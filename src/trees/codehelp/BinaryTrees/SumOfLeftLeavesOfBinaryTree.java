package trees.codehelp.BinaryTrees;

public class SumOfLeftLeavesOfBinaryTree {
    public int sumOfLeftLeaves(BinaryTreeNode node) {
        if(node == null) return 0;
        int sum = 0;
        if(node.left != null) {
            // check for left leaf
            if(node.left.left == null && node.left.right == null) {
                sum += node.left.data;
            }
            else sum += sumOfLeftLeaves(node.left);
        }
        // go right
        sum += sumOfLeftLeaves(node.right);
        return sum;
    }

    public static void main(String[] args) {

    }
}
