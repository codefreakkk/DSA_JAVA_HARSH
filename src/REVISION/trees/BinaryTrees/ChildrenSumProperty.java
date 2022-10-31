package REVISION.trees.BinaryTrees;

public class ChildrenSumProperty {
    public void solve(BinaryTreeNode node) {
        if(node == null) return;

        int child = 0;
        if(node.left != null) child += node.left.data;
        if(node.right != null) child += node.right.data;

        if(child >= node.data) node.data = child;
        else {
            if(node.left != null) node.left.data = node.data;
            if(node.right != null) node.right.data = node.data;
        }

        // recursive calls
        solve(node.left);
        solve(node.right);

        // backtrack
        int sum = 0;
        if(node.left != null) sum += node.left.data;
        if(node.right != null) sum += node.right.data;
        if(node.left != null || node.right != null) node.data = sum;
    }

    public static void main(String[] args) {

    }
}
