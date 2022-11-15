package trees.codehelp.BinaryTrees;

public class SumOfLongestPathFromRootToLeaf {
    public void solve(BinaryTreeNode node, int[] ans, int sum, int nodeLength) {
        if(node == null) return;

        solve(node.left, ans, sum + node.data, nodeLength + 1);
        solve(node.right, ans, sum + node.data, nodeLength + 1);
        if(nodeLength > ans[1]) {
            ans[0] = sum + node.data;
            ans[1] = nodeLength;
        }
    }

    public int sumOfLongestPathFromRootToLeaf(BinaryTreeNode node) {
        int[] ans = {0, 0};
        solve(node, ans, 0, 0);
        return ans[0];
    }

    public static void main(String[] args) {

    }
}
