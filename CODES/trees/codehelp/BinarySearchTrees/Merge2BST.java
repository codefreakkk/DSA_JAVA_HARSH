package trees.codehelp.BinarySearchTrees;

import java.util.*;

public class Merge2BST {
    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static void mergeList(List<Integer> list1, List<Integer> list2, List<Integer> finalList) {
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j))
                finalList.add(list1.get(i++));
            else
                finalList.add(list2.get(j++));
        }
        
        while(i < list1.size()) 
            finalList.add(list1.get(i++));

        while(j < list2.size())
            finalList.add(list2.get(j++));
    }

    public static TreeNode constructBSTFromInorder(List<Integer> inorder, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(inorder.get(mid));

        root.left = constructBSTFromInorder(inorder, start, mid - 1);
        root.right = constructBSTFromInorder(inorder, mid + 1, end);
        return root;
    }

    public static TreeNode mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);

        // merge two list
        List<Integer> finalList = new ArrayList<>();
        mergeList(list1, list2, finalList);

        // construct BST from inorder
        TreeNode root = constructBSTFromInorder(finalList, 0, finalList.size() - 1);
        return root;
    }

    public static void main(String[] args) {
    }
}
