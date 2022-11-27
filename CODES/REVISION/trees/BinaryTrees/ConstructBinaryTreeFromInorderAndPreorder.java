package REVISION.trees.BinaryTrees;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPreorder {
    public BinaryTreeNode solve(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map)
    {
        if(preStart > preEnd || inStart > inEnd) return null;

        // create a new root node
        BinaryTreeNode root = new BinaryTreeNode(preorder[preStart]);

        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = solve(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
        root.right = solve(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        return root;
    }

    public BinaryTreeNode buildTree(int[] inorder, int[] preorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return solve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static void main(String[] args) {

    }
}
