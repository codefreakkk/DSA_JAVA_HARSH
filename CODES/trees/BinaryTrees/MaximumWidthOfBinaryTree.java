package trees.BinaryTrees;

import java.util.*;

class TPair {
    BinaryTreeNode node;
    int index;

    public TPair(BinaryTreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class MaximumWidthOfBinaryTree {
    public int maximumWidthOfBinaryTree(BinaryTreeNode node) {
        Queue<TPair> queue = new LinkedList<>();
        int ans = 0;

        queue.offer(new TPair(node, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().index;
            int first = 0, last = 0;

            for(int i = 0; i < size; i++) {
                BinaryTreeNode element = queue.peek().node;
                int current_index = queue.peek().index - min;
                queue.poll();
                if(i == 0) first = current_index;
                if(i == size - 1) last = current_index;

                // add nodes in queue
                if(element.left != null) queue.add(new TPair(element.left, 2 * current_index + 1));
                if(element.right != null) queue.add(new TPair(element.right, 2 * current_index + 2));
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
