package trees.BinarySearchTrees;

public class ConstructBinarySearchTreeFromPreorder {
    public TreeNode solve(int[] preorder, int upperBound, int[] index) {
        if(index[0] >= preorder.length || preorder[index[0]] > upperBound) return null;

        TreeNode node = new TreeNode(preorder[index[0]++]);
        node.left = solve(preorder, node.data, index);
        node.right = solve(preorder, upperBound, index);

        return node;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public static void main(String[] args) {

    }
}
