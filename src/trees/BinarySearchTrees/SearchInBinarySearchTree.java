package trees.BinarySearchTrees;

public class SearchInBinarySearchTree {
    public TreeNode search(TreeNode node, int val) {
        if(node == null) return node;
        while(node != null) {
            if(val == node.data) return node;
            if(val < node.data) node = node.left;
            else node = node.right;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
