package trees;

import java.util.*;

public class RootToLeafPaths {
    public boolean solve(BinaryTreeNode node, int val, ArrayList<Integer> ans) {
        if(node == null) return false;

        ans.add(node.data);
        if(node.data == val) return true;

        if(solve(node.left, val, ans) || solve(node.right, val, ans)) return true;

        ans.remove(ans.size() - 1);
        return false;
    }

    public ArrayList<Integer> rootToLeafPath(BinaryTreeNode node, int val) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(node, val, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
