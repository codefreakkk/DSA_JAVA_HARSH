package trees.codehelp.BinarySearchTrees;

import java.util.*;

public class FlattenBSTToSortedList {
    public void pushAll(TreeNode node, List<Integer> list) {
        if(node == null) return;
        
        pushAll(node.left, list);
        list.add(node.data);
        pushAll(node.right, list);
    }    
    
    public TreeNode flatten(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        pushAll(node, list);

        TreeNode newRoot = node;
        TreeNode current = new TreeNode(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            TreeNode temp = new TreeNode(list.get(i));
            current.left = null;
            current.right = temp;
            current = temp;
        }
        current.left = null;
        current.right = null;

        return newRoot;
    }

    public static void main(String[] args) {
        
    }
}
