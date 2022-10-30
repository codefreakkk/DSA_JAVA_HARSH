package REVISION.trees.BinaryTrees;

import java.util.*;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrderTraversal(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        if(node == null) return answer;

        queue.offer(node);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> output = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                BinaryTreeNode element = queue.poll();
                if(element.left != null) queue.offer(element.left);
                if(element.right != null) queue.offer(element.right);
                output.add(element.data);
            }

            answer.add(output);
        }

        return answer;
    }




    public static void main(String[] args) {

    }
}
