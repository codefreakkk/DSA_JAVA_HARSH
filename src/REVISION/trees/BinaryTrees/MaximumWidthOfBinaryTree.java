package REVISION.trees.BinaryTrees;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    class Tupples {
        int index;
        BinaryTreeNode node;
        public Tupples(int index, BinaryTreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public int maxWidthOfBinaryTree(BinaryTreeNode node) {
        Queue<Tupples> queue = new LinkedList<>();
        int maxi = Integer.MIN_VALUE;

        queue.offer(new Tupples(0, node));
        while(!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().index;
            int first = 0, last = 0;

            for(int i = 0; i < size; i++) {
                BinaryTreeNode element = queue.peek().node;
                int currentIndex = queue.peek().index - min;
                queue.poll();

                if(i == 0) first = currentIndex;
                if(i == size - 1) last = currentIndex;

                // insert node in queue
                if(element.left != null) queue.offer(new Tupples(2 * currentIndex  + 1, element.left));
                if(element.right != null) queue.offer(new Tupples(2 * currentIndex + 2, element.right));
            }

            maxi = Math.max(maxi, last - first + 1);
        }

        return maxi;
    }

    public static void main(String[] args) {

    }
}
