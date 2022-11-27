package trees.codehelp.BinaryTrees;

import java.util.*;

public class AncestorInBinaryTree {
    
    public static boolean solve(BinaryTreeNode node, int target, ArrayList<Integer> ans) {
        if (node == null) return false;
        if (node.data == target)return true;

        boolean left = solve(node.left, target, ans);
        boolean right = solve(node.right, target, ans);

        if (left || right) {
            ans.add(node.data);
            return true;
        }

        return false;
    }

    public static ArrayList<Integer> ancestor(BinaryTreeNode node, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(node, target, ans);
        return ans;
    }

    public static void main(String[] args) {
    }
}
