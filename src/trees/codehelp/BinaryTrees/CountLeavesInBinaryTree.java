package trees.codehelp.BinaryTrees;

public class CountLeavesInBinaryTree {
    public int countLeaves(BinaryTreeNode node) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }
    public static void main(String[] args) {

    }
}
