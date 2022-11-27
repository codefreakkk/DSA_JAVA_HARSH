package trees.codehelp.BinaryTrees;

import java.util.*;

class Tupple {
    BinaryTreeNode node = null;
    int vertical = 0;
    int level = 0;
    public Tupple(int vertical, int level, BinaryTreeNode node) {
        this.vertical = vertical;
        this.level = level;
        this.node = node;
    }
}

public class VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalTraversal(BinaryTreeNode node) {
        List<List<Integer>> ans = new ArrayList<>();
        if(node == null) return ans;

        Queue<Tupple> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        queue.offer(new Tupple(0, 0, node));
        while(!queue.isEmpty()) {
            Tupple tupple = queue.poll();

            BinaryTreeNode element = tupple.node;
            int vertical = tupple.vertical;
            int level = tupple.level;

            // put values in treemap
            if(!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap<Integer, PriorityQueue<Integer>>());
            }
            if(!map.get(vertical).containsKey(level))  {
                map.get(vertical).put(level, new PriorityQueue<Integer>());

            }
            map.get(vertical).get(level).offer(element.data);

            if(element.left != null) {
                queue.offer(new Tupple(vertical - 1, level + 1, element.left));
            }
            if(element.right != null) {
                queue.offer(new Tupple(vertical + 1, level + 1, element.right));
            }
        }


        for(TreeMap<Integer, PriorityQueue<Integer>> mp : map.values()) {
            List<Integer> output = new ArrayList<>();
            for(PriorityQueue<Integer> pq : mp.values()) {
                while(!pq.isEmpty()) output.add(pq.poll());
            }
            ans.add(output);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
