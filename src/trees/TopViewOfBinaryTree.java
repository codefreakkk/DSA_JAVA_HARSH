package trees;

import java.util.*;

class Pairs {
    BinaryTreeNode node;
    int vertical;

    public Pairs(BinaryTreeNode node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}

public class TopViewOfBinaryTree {
    public ArrayList<Integer> topViewOfBinaryTree(BinaryTreeNode node) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pairs> queue = new LinkedList<>();

        queue.add(new Pairs(node, 0));
        while(!queue.isEmpty()) {
            Pairs pair = queue.poll();
            BinaryTreeNode element = pair.node;
            int vertical = pair.vertical;

            // store vertical line with node
            if(!map.containsKey(vertical)) map.put(vertical, element.data);

            // push left and right in queue
            if(element.left != null) queue.offer(new Pairs(element.left, vertical - 1));
            if(element.right != null) queue.offer(new Pairs(element.right, vertical + 1));
        }

        // store ans
        ArrayList<Integer> ans = new ArrayList<>();
        for(int val : map.values()) ans.add(val);

        return ans;

    }

    public static void main(String[] args) {

    }
}
