package trees.codehelp.BinaryTrees;

import java.util.*;

public class LeftViewOfBinaryTree {
    public void solve(BinaryTreeNode node, ArrayList<Integer> ans, int level) {
        if(node == null) return;

        if(ans.size() == level) ans.add(node.data);
        solve(node.left, ans, level + 1);
        solve(node.right, ans, level + 1);
    }

    public ArrayList<Integer> leftView(BinaryTreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(node, ans, 0);
        return ans;
    }

    public static void main(String[] args) {

    }
}
