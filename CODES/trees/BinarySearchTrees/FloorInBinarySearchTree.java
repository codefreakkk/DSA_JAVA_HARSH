package trees.BinarySearchTrees;

public class FloorInBinarySearchTree {
    public int floorInBinarySearchTree(TreeNode node, int x) {
        if(node == null) return -1;
        int floor = -1;

        while(node != null) {
            if(node.data == x) return x;
            if(node.data > x) node = node.left;
            else {
                floor = node.data;
                node = node.right;
            }
        }

        return floor;
    }

    public static void main(String[] args) {

    }
}
