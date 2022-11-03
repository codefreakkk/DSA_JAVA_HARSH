package trees.BinarySearchTrees;

public class CeilInBinarySearchTree {
    public int findCeil(TreeNode node, int key) {
        if(node == null) return -1;
        int ceil = -1;

        while(node != null) {
            if(node.data == key) return key;
            if(node.data > key) {
                ceil = node.data;
                node = node.left;
            }
            else node = node.right;
        }

        return ceil;
    }

    public static void main(String[] args) {

    }
}
