package REVISION.trees.BinaryTrees;

import java.util.*;

public class RootToNodePath {
    public boolean solve(BinaryTreeNode node, int val, ArrayList<Integer> ans) {
        if(node == null) return false;

        if(node.data == val) return true;
        ans.add(node.data);
        boolean left = solve(node.left, val, ans);
        boolean right = solve(node.right, val, ans);

        // backtrack
        if(left || right) return true;
        ans.remove(ans.size() - 1);
        return false;
    }

    public ArrayList<Integer> rootToNodePath(BinaryTreeNode node, int val) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null) return ans;
        solve(node, val, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
