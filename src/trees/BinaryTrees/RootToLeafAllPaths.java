package trees.BinaryTrees;

import java.util.*;

public class RootToLeafAllPaths {
    public boolean isLeaf(BinaryTreeNode node) {
        return node.left == null && node.right == null;
    }

    public void solve(BinaryTreeNode node, String output, List<String> ans) {
        if(node != null) {
            output += node.data;
            if(isLeaf(node)) ans.add(output);
            output += "->";

            solve(node.left, output, ans);
            solve(node.right, output, ans);
        }
    }

    public List<String> rootToLeafAllPaths(BinaryTreeNode node) {
        List<String> ans = new ArrayList<>();
        solve(node, "", ans);
        return ans;
    }

}
