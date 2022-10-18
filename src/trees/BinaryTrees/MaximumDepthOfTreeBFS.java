package trees.BinaryTrees;

import java.util.*;

public class MaximumDepthOfTreeBFS {
    public static int maxDepth(BinaryTreeNode node) {
        if(node == null) return 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        int level = 0;
        queue.offer(node);
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for(int i = 0; i < size; i++) {
                BinaryTreeNode element = queue.remove();
                if(element.left != null) queue.add(element.left);
                if(element.right != null) queue.add(element.right);
            }
        }

        return level;
    }

    public static void main(String[] args) {

    }
}
