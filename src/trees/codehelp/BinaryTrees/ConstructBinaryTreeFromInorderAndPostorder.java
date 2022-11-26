package trees.codehelp.BinaryTrees;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorder {
    public BinaryTreeNode solve(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if(postStart > postEnd || inStart > inEnd) return null;

        // create root not
        BinaryTreeNode root = new BinaryTreeNode(postorder[postEnd]);
        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;

        // recursive calls
        root.left = solve(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, inRoot - 1, map);
        root.right = solve(postorder, postStart + numsLeft, postEnd - 1, inorder, inRoot + 1, inEnd, map);
        return root;
    }

    public BinaryTreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        BinaryTreeNode root = solve(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public static void main(String[] args) {

    }
}
