package REVISION.trees.BinaryTrees;

import java.util.*;

public class MinimumTimeTakenToBurnTree {
    public BinaryTreeNode getTargetNode(BinaryTreeNode node, int target) {
        if(node == null) return node;
        if(node.data == target) return node;

        BinaryTreeNode left = getTargetNode(node.left, target);
        if(left != null) return left;
        BinaryTreeNode right = getTargetNode(node.right, target);
        if(right != null) return right;

        return null;
    }

    public void markParent(BinaryTreeNode node, HashMap<BinaryTreeNode, BinaryTreeNode> parent) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        queue.offer(node);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                BinaryTreeNode element = queue.poll();
                if(element.left != null) {
                    queue.offer(element.left);
                    parent.put(element.left, element);
                }
                if(element.right != null) {
                    queue.offer(element.right);
                    parent.put(element.right, element);
                }
            }
        }
    }

    public int minimumTimeTaken(BinaryTreeNode node, int target) {
        BinaryTreeNode targetNode = getTargetNode(node, target);
        HashMap<BinaryTreeNode, BinaryTreeNode> parent = new HashMap<>();
        markParent(node, parent);
        HashMap<BinaryTreeNode, Boolean> visited = new HashMap<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        int burn = 0;
        queue.offer(targetNode);
        visited.put(targetNode, true);
        while(!queue.isEmpty()) {
            int size = queue.size();
            burn++;

            for(int i = 0; i < size; i++) {
                BinaryTreeNode element = queue.poll();
                // move left
                if(!visited.containsKey(element.left) && element.left != null) {
                    queue.offer(element.left);
                    visited.put(element.left, true);
                }
                // move right
                if(!visited.containsKey(element.right) && element.right != null) {
                    queue.offer(element.right);
                    visited.put(element.right, true);
                }
                // move upward
                if(parent.get(element) != null && !visited.containsKey(parent.get(element))) {
                    queue.offer(parent.get(element));
                    visited.put(parent.get(element), true);
                }
            }
        }

        return burn - 1;
    }

    public static void main(String[] args) {

    }
}
