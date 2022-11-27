package trees.BinarySearchTrees;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode node,  TreeNode x) {
        TreeNode ans = null;

        while(node != null) {
            if(x.data >= node.data) node = node.right;
            else {
                ans = node;
                node = node.left;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
