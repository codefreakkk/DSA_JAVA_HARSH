package trees.BinaryTrees;

public class SecondMinimumNodeInBinaryTree {
    public int findSecondMinimumValue(BinaryTreeNode node) {
        if(node == null || (node.left == null && node.right == null)) return -1;

        int left = node.left.data;
        int right = node.right.data;
        
        if(node.left.data == node.data) {
            left = findSecondMinimumValue(node.left);
        }
        if(node.right.data == node.data) {
            right = findSecondMinimumValue(node.right);
        }

        if(left != -1 && right != -1) {
            return Math.min(left, right);
        }
        if(left == -1) {
            return right;
        }
        return left;
    }
 
    public static void main(String[] args) {}
}
