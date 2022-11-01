package REVISION.trees.BinaryTrees;

import java.util.*;

public class CheckCompleteBinaryTree {
    public boolean checkForCompleteBinaryTree(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        boolean end = false;

        queue.offer(node);
        while(!queue.isEmpty()) {
            BinaryTreeNode element = queue.poll();
            if(element == null) end = true;
            else {
                if(end) return false;
                queue.offer(element.left);
                queue.offer(element.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
