package REVISION.trees.BinaryTrees;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public void markParent(BinaryTreeNode node, HashMap<BinaryTreeNode, BinaryTreeNode> parent) {
        Queue<BinaryTreeNode>  queue = new LinkedList<>();
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

    public List<Integer> distanceK(BinaryTreeNode node, BinaryTreeNode target, int k) {
        HashMap<BinaryTreeNode, BinaryTreeNode> parent = new HashMap<>();
        markParent(node, parent);
        HashMap<BinaryTreeNode, Boolean> visited = new HashMap<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        int distance = 0;

        visited.put(target, true);
        queue.offer(target);
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(distance == k) break;

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
            distance++;
        }

        // store final answer from queue
        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) answer.add(queue.poll().data);
        return answer;
    }

    public static void main(String[] args) {

    }
}
