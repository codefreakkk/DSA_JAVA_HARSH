package trees.BinarySearchTrees;

import java.util.*;

public class ConstructBinarySearchTreeFromPostorder {
    public TreeNode solve(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map)
    {
        if(inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = solve(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, inRoot - 1, map);
        root.right = solve(postorder, postStart + numsLeft, postEnd - 1, inorder, inRoot + 1, inEnd, map);
        return root;
    }

    public TreeNode constructTree(int[] postorder) {
        int[] inorder = postorder;
        Arrays.sort(inorder);
        int size = postorder.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++) map.put(inorder[i], i);

        return solve(postorder, 0, size - 1, inorder, 0, size - 1, map);
    }

    public static void main(String[] args) {

    }
}
