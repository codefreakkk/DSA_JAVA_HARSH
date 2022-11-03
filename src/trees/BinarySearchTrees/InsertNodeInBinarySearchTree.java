package trees.BinarySearchTrees;

public class InsertNodeInBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode node, int val) {
        if(node == null) return new TreeNode(val);
        TreeNode root = node;

        while(node != null) {
            if(node.data > val) {
                if(node.left != null) node = node.left;
                else {
                    node.left = new TreeNode(val);
                    return root;
                }
            }
            else {
                if(node.right != null) node = node.right;
                else {
                    node.right = new TreeNode(val);
                    return root;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
