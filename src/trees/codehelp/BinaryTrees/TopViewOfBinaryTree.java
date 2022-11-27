package trees.codehelp.BinaryTrees;

import java.util.*;

class Pairs {
    int vertical;
    BinaryTreeNode node;
    public Pairs(int vertical, BinaryTreeNode node) {
        this.vertical = vertical;
        this.node = node;
    }
}

public class TopViewOfBinaryTree {
    public ArrayList<Integer> topViewOfBinaryTree(BinaryTreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pairs> queue = new LinkedList<>();

        queue.offer(new Pairs(0, node));
        while(!queue.isEmpty()) {
            Pairs pair = queue.poll();
            int vertical = pair.vertical;
            BinaryTreeNode element = pair.node;

            // if map does not contain vertical push into map
            if(!map.containsKey(vertical)) map.put(vertical, element.data);

            if(element.left != null) queue.offer(new Pairs(vertical - 1, element.left));
            if(element.right != null) queue.offer(new Pairs(vertical + 1, element.right));
        }

        for(int val : map.values()) ans.add(val);
        return ans;
    }

    public static void main(String[] args) {

    }
}
