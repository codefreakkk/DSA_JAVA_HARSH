package trees.codehelp.BinarySearchTrees;

import java.util.*;

public class BalanceABST {
    public void inorder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }

    public TreeNode solve(int start, int end, List<Integer> list) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        
        root.left = solve(start, mid - 1, list);
        root.right = solve(mid + 1, end, list);
        
        return root;
    }

    public TreeNode balanceBST(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        inorder(node, list);
        TreeNode root = solve(0, list.size() - 1, list);
        return root;
    }

    public static void main(String[] args) {
    }
}
