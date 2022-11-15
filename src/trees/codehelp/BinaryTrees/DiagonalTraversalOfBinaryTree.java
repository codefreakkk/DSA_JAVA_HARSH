package trees.codehelp.BinaryTrees;

import java.util.*;

public class DiagonalTraversalOfBinaryTree {
    public ArrayList<Integer> diagonal(BinaryTreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null) return ans;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            BinaryTreeNode element = queue.poll();
            while(element != null) {
                if(element.left != null) queue.offer(element.left);
                ans.add(element.data);
                element = element.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
