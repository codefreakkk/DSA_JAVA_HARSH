package trees.BinarySearchTrees;

import java.util.*;

public class BalanceABST {
    public void inorder(TreeNode node, List<Integer> list) {
        if(node == null) return;

        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }
    public TreeNode balance(List<Integer> list, int start, int end) {
        if(start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = balance(list, start, mid - 1);
        root.right = balance(list, mid + 1, end);
        return root;
    }

    public TreeNode balanceBST(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        inorder(node, list);
        return balance(list, 0, list.size() - 1);
    }

    public static void main(String[] args) {

    }
}
