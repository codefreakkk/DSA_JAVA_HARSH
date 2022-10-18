package trees.BinaryTrees;

public class PostorderRecursive {
    public static void postorder(BinaryTreeNode root) {
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
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
        postorder(tree);
    }
}
