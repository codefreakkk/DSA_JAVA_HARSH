package REVISION.trees.BinaryTrees;

import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrderTraversal(BinaryTreeNode node) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(node == null) return answer;

        boolean flag = true;
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

            if(flag) answer.add(output);
            else {
                Collections.reverse(output);
                answer.add(output);
            }
            flag = !flag;
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
