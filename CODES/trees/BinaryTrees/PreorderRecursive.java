package trees.BinaryTrees;

public class PreorderRecursive {
    public void preorder(BinaryTreeNode root) {
        if(root == null) return;

        System.out.print(root.data + " ");

        // recursive calls for preorder
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        PreorderRecursive p = new PreorderRecursive();
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
        p.preorder(tree);
    }
}
