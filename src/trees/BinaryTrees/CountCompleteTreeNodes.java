package trees.BinaryTrees;

public class CountCompleteTreeNodes {
    public int findLeftHeight(BinaryTreeNode node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.left;
        }

        return height;
    }

    public int findRightHeight(BinaryTreeNode node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.right;
        }

        return height;
    }

    public int countNodes(BinaryTreeNode node) {
        if(node == null) return 0;

        int leftHeight = findLeftHeight(node);
        int rightHeight = findRightHeight(node);

        // if perfect binary tree return form here only no need to go down
        if(leftHeight == rightHeight) return (1 << leftHeight) - 1;

        // if not perfect binary tree make further recursion calls
        return 1 + countNodes(node.left) + countNodes(node.right);
    }




    public static void main(String[] args) {

    }
}
