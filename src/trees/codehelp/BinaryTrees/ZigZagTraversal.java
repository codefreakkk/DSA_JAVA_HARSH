package trees.codehelp.BinaryTrees;

import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigZagLevelOrderTraversal(BinaryTreeNode node) {
        List<List<Integer>> ans = new ArrayList<>();
        if (node == null) return ans;

        boolean flag = true;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> output = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode element = queue.poll();
                output.add(element.data);
                if (element.left != null) queue.offer(element.left);
                if (element.right != null) queue.offer(element.right);
            }
            if (flag) ans.add(output);
            else {
                Collections.reverse(output);
                ans.add(output);
            }
            flag = !flag;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
