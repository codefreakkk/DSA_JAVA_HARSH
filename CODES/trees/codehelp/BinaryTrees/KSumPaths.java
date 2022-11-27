package trees.codehelp.BinaryTrees;

import java.util.*;

public class KSumPaths {
    public void solve(BinaryTreeNode node, int k, int[] count, List<Integer> path) {
        if(node == null) return;

        path.add(node.data);
        int sum = 0;
        for(int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if(sum == k) count[0]++;
        }

        // left and right recursive calls
        solve(node.left, k, count, path);
        solve(node.right, k, count, path);

        // backtrack
        path.remove(path.size() - 1);
    }

    public int sumK(BinaryTreeNode node, int k) {
        List<Integer> path = new ArrayList<>();
        int[] count = {0};
        solve(node, k, count, path);
        return count[0];
    }

    public static void main(String[] args) {

    }
}
