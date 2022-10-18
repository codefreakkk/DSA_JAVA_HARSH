package trees.BinaryTrees;

import java.util.*;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(node == null) return ans;

        queue.offer(node);
        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < level; i++) {
                BinaryTreeNode element = queue.remove();
                if(element.left != null) queue.add(element.left);
                if(element.right != null) queue.add(element.right);
                list.add(element.data);
            }
            ans.add(list);
        }

        return ans;
    }


    public static void main(String[] args) {

    }
}
