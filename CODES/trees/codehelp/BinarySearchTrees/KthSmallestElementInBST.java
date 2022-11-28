package trees.codehelp.BinarySearchTrees;

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode node, int k) {
        TreeNode current = node;
        int count = 0, answer = 0;

        while (current != null) {
            if (current.left == null) {
                count++;
                answer = current.data;
                current = current.right;
            } else {
                TreeNode prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    count++;
                    answer = current.data;
                    prev.right = null;
                    current = current.right;
                }
            }
            if (count == k) break;
        }
        return answer;
    }

    public static void main(String[] args) {
    }
}
