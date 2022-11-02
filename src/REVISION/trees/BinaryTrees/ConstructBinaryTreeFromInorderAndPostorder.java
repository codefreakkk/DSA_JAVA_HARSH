package REVISION.trees.BinaryTrees;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorder {
    public BinaryTreeNode solve(int[] postorder, int postStart, int postEnd, int[] inorder,
                                int inStart, int inEnd, HashMap<Integer, Integer> map)
    {
        if(postStart > postEnd || inStart > inEnd) return null;

        // create a new root node
        BinaryTreeNode root = new BinaryTreeNode(postorder[postEnd]);

        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = solve(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, inRoot - 1, map);
        root.right = solve(postorder, postStart + numsLeft, postEnd - 1, inorder, inRoot + 1, inEnd, map);
        return root;
    }

    public BinaryTreeNode buildTree(int[] inorder, int[] postorder) {
        int size = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++) map.put(inorder[i], i);
        return solve(postorder, 0, size - 1, inorder, 0, size - 1, map);
    }

    public static void main(String[] args) {

    }
}
