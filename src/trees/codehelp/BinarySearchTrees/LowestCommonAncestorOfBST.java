package trees.codehelp.BinarySearchTrees;

public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return node;
        int data = node.data;

        if(p.data < data && q.data < data) return lowestCommonAncestor(node.left, p, q);
        if(p.data > data && q.data > data) return lowestCommonAncestor(node.right, p, q);

        return node;
    }

    public static void main(String[] args) {

    }
}
