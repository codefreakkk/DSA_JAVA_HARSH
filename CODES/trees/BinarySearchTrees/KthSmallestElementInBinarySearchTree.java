package trees.BinarySearchTrees;

public class KthSmallestElementInBinarySearchTree {
    public int kthSmallestElement(TreeNode node, int k) {
        TreeNode root = node;
        int count = 0, answer = 0;

        while(node != null) {
            if(node.left == null) {
                count++;
                answer = node.data;
                node = node.right;
            }
            else {
                TreeNode prev = node.left;
                while(prev.right != null && prev.right != node) prev = prev.right;
                if(prev.right == null) {
                    prev.right = node;
                    node = node.left;
                }
                else {
                    prev.right = null;
                    count++;
                    answer = node.data;
                    node = node.right;
                }
            }
            if(count == k) break;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
