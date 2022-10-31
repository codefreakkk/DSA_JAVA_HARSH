package REVISION.trees.BinaryTrees;

import java.util.*;

public class MaximumDepthOfBinaryTreeBFS {
    public int maxDepth(BinaryTreeNode node) {
        if(node == null) return 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        int level = 0;

        queue.offer(node);
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for(int i = 0; i < size; i++) {
                BinaryTreeNode element = queue.poll();
                if(element.left != null) queue.offer(element.left);
                if(element.right != null) queue.offer(element.right);
            }
        }

        return level;
    }

    public static void main(String[] args) {

    }
}
