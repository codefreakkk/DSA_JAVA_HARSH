package REVISION.trees.BinaryTrees;

import java.util.*;

class Pairs {
    BinaryTreeNode node;
    int vertical;
    public Pairs(int vertical, BinaryTreeNode node) {
        this.vertical = vertical;
        this.node = node;
    }
}


public class BottomViewOfBinaryTree {
    public ArrayList<Integer> bottomView(BinaryTreeNode node) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pairs> queue = new LinkedList<>();

        queue.offer(new Pairs(0, node));
        while(!queue.isEmpty()) {
            Pairs pair = queue.poll();
            int vertical = pair.vertical;
            BinaryTreeNode element = pair.node;
            map.put(vertical, element.data);

            if(element.left != null) queue.offer(new Pairs(vertical - 1, element.left));
            if(element.right != null) queue.offer(new Pairs(vertical + 1, element.right));
        }

        // store final ans
        ArrayList<Integer> ans = new ArrayList<>();
        for(int val : map.values()) ans.add(val);
        return ans;
    }

    public static void main(String[] args) {

    }
}
