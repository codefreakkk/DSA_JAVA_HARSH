package trees.codehelp.BinarySearchTrees;

public class ConstructBSTFromPreorder {
    public TreeNode solve(int[] preorder, int upperBound, int[] index) {
        if (index[0] >= preorder.length || preorder[index[0]] > upperBound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = solve(preorder, root.data, index);
        root.right = solve(preorder, upperBound, index);
        
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = solve(preorder, Integer.MAX_VALUE, new int[]{0});
        return root;
    }

    public static void main(String[] args) {}
}
