package trees.BinaryTrees;

public class SameTree {
    public boolean isSameTree(BinaryTreeNode node1, BinaryTreeNode node2) {
        if(node1 == null || node2 == null) {
            return (node1 == node2);
        }

        return (node1.data == node2.data) &&
                (isSameTree(node1.left, node2.left)) &&
                (isSameTree(node1.right, node2.right));
    }

    public static void main(String[] args) {

    }
}
