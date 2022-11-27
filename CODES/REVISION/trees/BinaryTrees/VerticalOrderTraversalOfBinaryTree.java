package REVISION.trees.BinaryTrees;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {

    class Tupple {
        private int level;
        private int vertical;
        private BinaryTreeNode node;

        Tupple(int level, int vertical, BinaryTreeNode node) {
            this.level = level;
            this.vertical = vertical;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalOrderTraversal(BinaryTreeNode node) {
        List<List<Integer>> answer = new ArrayList<>();
        if(node == null) return answer;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tupple> queue = new LinkedList<>();

        queue.offer(new Tupple(0, 0, node));
        while(!queue.isEmpty()) {
            Tupple tupple = queue.poll();
            int level = tupple.level;
            int vertical = tupple.vertical;
            BinaryTreeNode element = tupple.node;

            // store data in map
            if(!map.containsKey(vertical)) map.put(vertical, new TreeMap<>());
            if(!map.get(vertical).containsKey(level)) map.get(vertical).put(level, new PriorityQueue<>());
            map.get(vertical).get(level).offer(element.data);

            // traverse left and right
            if(element.left != null) queue.offer(new Tupple(level + 1, vertical - 1, element.left));
            if(element.right != null) queue.offer(new Tupple(level + 1, vertical + 1, element.right));
        }

        // store final answer
        for(TreeMap<Integer, PriorityQueue<Integer>> mp : map.values()) {
            answer.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : mp.values()) {
                while(!pq.isEmpty()) answer.get(answer.size() - 1).add(pq.poll());
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
