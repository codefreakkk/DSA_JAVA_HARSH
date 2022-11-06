package trees.BinarySearchTrees;

public class RecoverBST {
    TreeNode first, middle, last, prev;
    public void solve(TreeNode node) {
        if(node == null) return;

        solve(node.left);
        if(prev != null && node.data < prev.data) {
            // if values are adjacent
            if(first == null) {
                first = prev;
                middle = node;
            }
            // if values are not adjacent
            else last = node;
        }

        // mark previous element for further checking
        prev = node;
        solve(node.right);
    }
    public void recoverTree(TreeNode node) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        solve(node);

        // if elements are adjacent
        if(first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        else if(first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }
    public static void main(String[] args) {

    }
}
