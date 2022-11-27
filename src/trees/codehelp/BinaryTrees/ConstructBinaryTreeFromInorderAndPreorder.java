package trees.codehelp.BinaryTrees;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPreorder {
    public BinaryTreeNode solve(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if(inStart > inEnd || preStart > preEnd) return null;

        BinaryTreeNode root = new BinaryTreeNode(preorder[preStart]);

        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = solve(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
        root.right = solve(preorder, preStart + numsLeft + 1, preEnd, inorder,inRoot + 1, inEnd, map);
        return root;
    }

    public BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        int preorderSize = preorder.length;
        int inorderSize = inorder.length;

        // hash preorder values
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < preorderSize; i++) map.put(inorder[i], i);

        BinaryTreeNode root = solve(preorder, 0, preorderSize, inorder, 0, inorderSize, map);
        return root;
    }

    public static void main(String[] args) {

    }
}
