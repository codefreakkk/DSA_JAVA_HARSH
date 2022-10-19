package trees.BinaryTrees;

import java.util.*;

public class CheckCompleteBinaryTree {
    public boolean isCompleteBinaryTree(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        boolean end = false;

        queue.add(node);
        while(!queue.isEmpty()) {
            BinaryTreeNode element = queue.poll();
            if(element == null) end = true;
            else {
                if(end) return false;
                queue.add(element.left);
                queue.add(element.right);
            }
        }

        return true;
    }


    public static void main(String[] args) {

    }
}
