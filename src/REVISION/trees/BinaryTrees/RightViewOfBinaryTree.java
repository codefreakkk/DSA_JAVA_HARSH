package REVISION.trees.BinaryTrees;

import java.util.*;

public class RightViewOfBinaryTree {
    public void solve(BinaryTreeNode node, List<Integer> ans, int level) {
        if(node == null) return;

        if(level == ans.size()) ans.add(node.data);
        solve(node.right, ans, level + 1);
        solve(node.left, ans, level + 1);
    }

    public List<Integer> rightSideView(BinaryTreeNode node) {
        List<Integer> ans = new ArrayList<>();
        solve(node, ans, 0);
        return ans;
    }

    public static void main(String[] args) {

    }
}
