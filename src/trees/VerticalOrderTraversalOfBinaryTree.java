package trees;

import java.util.*;

class Tupple {
    BinaryTreeNode node;
    int vertical;
    int level;
    public Tupple(BinaryTreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
    }
}

public class VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalOrderTraversal(BinaryTreeNode node) {
        Queue<Tupple> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.add(new Tupple(node, 0, 0));

        while(!queue.isEmpty()) {
            Tupple tupple = queue.poll();
            BinaryTreeNode element = tupple.node;
            int data = element.data;
            int vertical = tupple.vertical;
            int level = tupple.level;

            if(!map.containsKey(vertical)) map.put(vertical, new TreeMap<>());
            if(!map.get(vertical).containsKey(level)) map.get(vertical).put(level, new PriorityQueue<>());
            map.get(vertical).get(level).offer(data);


            if(element.left != null) queue.offer(new Tupple(element.left, vertical - 1, level + 1));
            if(element.right != null) queue.offer(new Tupple(element.right, vertical + 1, level + 1));
        }

        // store ans
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> mp : map.values()) {
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : mp.values()) {
                while(!pq.isEmpty()) ans.get(ans.size() - 1).add(pq.poll());
            }
        }

        return ans;
    }


    public static void main(String[] args) {

    }
}
