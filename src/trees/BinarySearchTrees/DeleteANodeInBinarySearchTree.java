package trees.BinarySearchTrees;

public class DeleteANodeInBinarySearchTree {
    public TreeNode deleteNode(TreeNode node, int key) {
        if(node == null) return node;
        if(node.data == key) return helper(node);

        TreeNode root = node;
        while(node != null) {
            if(node.data > key) {
                if(node.left != null && node.left.data == key) {
                    node.left = helper(node.left);
                    break;
                }
                else node = node.left;
            }
            else {
                if(node.right != null && node.right.data == key) {
                    node.right = helper(node.right);
                    break;
                }
                else node = node.right;
            }
        }

        return root;
    }

    public TreeNode helper(TreeNode node) {
        if(node.left == null) return node.right;
        if(node.right == null) return node.left;
        TreeNode rightChild = node.right;
        TreeNode rightLast = findLast(node.left);
        rightLast.right = rightChild;
        return node.left;
    }

    public TreeNode findLast(TreeNode node) {
        while(node.right != null) node = node.right;
        return node;
    }

    public static void main(String[] args) {

    }
}
