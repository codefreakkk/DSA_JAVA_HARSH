package REVISION.trees.BinaryTrees;

public class CountCompleteTreeNodes {
    public int countLeft(BinaryTreeNode node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    public int countRight(BinaryTreeNode node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public int countNodes(BinaryTreeNode node) {
        if(node == null) return 0;

        int leftCount = countLeft(node);
        int rightCount = countRight(node);

        if(leftCount == rightCount) return (1 << leftCount) - 1;
        return countNodes(node.left) + countNodes(node.right) + 1;
    }

    public static void main(String[] args) {

    }
}
