package trees.codehelp.BinarySearchTrees;

import java.util.*;

public class Merge2BST_GFG {
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public void merge(List<Integer> list1, List<Integer> list2, List<Integer> answer) {
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j))
                answer.add(list1.get(i++));
            else
                answer.add(list2.get(j++));
        }

        while (i < list1.size())
            answer.add(list1.get(i++));

        while (j < list2.size())
            answer.add(list2.get(j++));
    }

    public List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);

        // merge list's
        List<Integer> answer = new ArrayList<>();
        merge(list1, list2, answer);
        return answer;
    }

    public static void main(String[] args) {}
}
