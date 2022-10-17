package trees;

public class SymmetricTree {
    public boolean solve(BinaryTreeNode node1, BinaryTreeNode node2) {
        if(node1 == null || node2== null) return node1 == node2;

        if(node1.data != node2.data) return false;

        return solve(node1.left, node2.right) && solve(node1.right, node2.left);
    }

    public boolean isSymmetric(BinaryTreeNode node) {
        return node == null || solve(node.left, node.right);
    }

    public static void main(String[] args) {

    }
}
