package REVISION.trees.BinaryTrees;

import java.util.*;

public class TopViewOfBinaryTree {
    class Pair {
        private int vertical;
        private BinaryTreeNode node;
        public Pair(int vertical, BinaryTreeNode node) {
            this.node = node;
            this.vertical = vertical;
        }
    }

    public ArrayList<Integer> topView(BinaryTreeNode node) {
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        queue.offer(new Pair(0, node));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int vertical = pair.vertical;
            BinaryTreeNode element = pair.node;

            if(!map.containsKey(vertical)) map.put(vertical, element.data);
            if(element.left != null) queue.offer(new Pair(vertical - 1, element.left));
            if(element.right != null) queue.offer(new Pair(vertical + 1, element.right));
        }

        // store final answer
        ArrayList<Integer> answer = new ArrayList<>();
        for(int val : map.values()) answer.add(val);
        return answer;
    }

    public static void main(String[] args) {

    }
}
