package trees.BinaryTrees;

public class BinaryTreeRepresentation {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(5);
    }
}
