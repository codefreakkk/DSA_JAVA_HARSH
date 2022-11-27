package trees.BinarySearchTrees;

import java.util.*;

public class ConvertBinaryTreeToBST {
    public void inorder(TreeNode node, List<Integer> list) {
        if(node == null) return;

        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }

    public void buildTree(TreeNode node, List<Integer> list, int[] index) {
        if(node == null) return;

        buildTree(node.left, list, index);
        node.data = list.get(index[0]++);
        buildTree(node.right, list, index);
    }

    public TreeNode binaryTreeToBST(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        inorder(node, list);
        Collections.sort(list);
        buildTree(node, list, new int[]{0});
        return node;
    }

    public static void main(String[] args) {

    }
}
