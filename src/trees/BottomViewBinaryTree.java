package trees;

import java.util.*;

class Tupples {
    BinaryTreeNode node;
    int vertical;

    public Tupples(BinaryTreeNode node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}

public class BottomViewBinaryTree {
    public ArrayList<Integer> bottomView(BinaryTreeNode node) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tupples> queue = new LinkedList<>();

        queue.add(new Tupples(node, 0));
        while(!queue.isEmpty()) {
            Tupples tupple = queue.poll();
            BinaryTreeNode element = tupple.node;
            int vertical = tupple.vertical;

            // store node and vertical in map
            map.put(vertical, element.data);

            // store left and right in queue
            if(element.left != null) queue.offer(new Tupples(element.left, vertical - 1));
            if(element.right != null) queue.offer(new Tupples(element.right, vertical + 1));
        }

        // store final ans
        ArrayList<Integer> ans = new ArrayList<>();
        for(int val : map.values()) ans.add(val);

        return ans;
    }


    public static void main(String[] args) {

    }
}
