package trees.BinaryTrees;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public void markParent(BinaryTreeNode node, HashMap<BinaryTreeNode, BinaryTreeNode> parent) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
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

    public List<Integer> distanceK(BinaryTreeNode node, BinaryTreeNode target, int k) {
        HashMap<BinaryTreeNode, BinaryTreeNode> parent = new HashMap<>();
        markParent(node, parent);

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        HashMap<BinaryTreeNode, Boolean> visited = new HashMap<>();
        int currentSize = 0;
        queue.offer(target);
        visited.put(target, true);

        while(!queue.isEmpty()) {
            if(currentSize == k) break;
            currentSize++;
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                BinaryTreeNode element = queue.poll();

                // check left
                if(element.left != null && visited.get(element.left) == null) {
                    queue.offer(element.left);
                    visited.put(element.left, true);
                }
                // check right
                if(element.right != null && visited.get(element.right) == null) {
                    queue.offer(element.right);
                    visited.put(element.right, true);
                }
                // check parent
                if(parent.get(element) != null && visited.get(parent.get(element)) == null) {
                    queue.offer(parent.get(element));
                    visited.put(parent.get(element), true);
                }
            }
        }

        // store ans
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) ans.add(queue.remove().data);

        return ans;
    }

    public static void main(String[] args) {

    }
}
