package trees.codehelp.BinaryTrees;

import java.util.*;

public class BottomViewOfBinaryTree {
    public ArrayList<Integer> bottomViewOfBinaryTree(BinaryTreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pairs> queue = new LinkedList<>();

        queue.offer(new Pairs(0, node));
        while(!queue.isEmpty()) {
            Pairs pair = queue.poll();
            BinaryTreeNode element = pair.node;
            int vertical = pair.vertical;

            // put data in map
            map.put(vertical, element.data);

            if(element.left != null) queue.offer(new Pairs(vertical - 1, element.left));
            if(element.right != null) queue.offer(new Pairs(vertical + 1, element.right));
        }

        for(int val : map.values()) ans.add(val);
        return ans;
    }

    public static void main(String[] args) {

    }
}
