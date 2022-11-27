package trees.BinaryTrees;

public class InorderRecursive {
    public static void inorder(BinaryTreeNode root) {
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode(1);
        tree.left = new BinaryTreeNode(2);
        tree.right = new BinaryTreeNode(3);
        tree.left.left = new BinaryTreeNode(4);
        tree.left.right = new BinaryTreeNode(5);
        tree.left.right.left = new BinaryTreeNode(6);
        tree.right.left = new BinaryTreeNode(7);
        tree.right.right = new BinaryTreeNode(8);
        tree.right.right.left = new BinaryTreeNode(9);
        tree.right.right.right = new BinaryTreeNode(10);
        inorder(tree);
    }
}
