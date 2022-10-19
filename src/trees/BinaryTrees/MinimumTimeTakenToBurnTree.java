package trees.BinaryTrees;

import java.util.*;

public class MinimumTimeTakenToBurnTree {
    public void markParent(BinaryTreeNode node, HashMap<BinaryTreeNode, BinaryTreeNode> parent) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);

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

    public BinaryTreeNode getTargetNode(BinaryTreeNode node, int target) {
        if(node == null) return node;

        if(node.data == target) return node;

        BinaryTreeNode left = getTargetNode(node.left, target);
        BinaryTreeNode right = getTargetNode(node.right, target);

        if(left == null) return right;
        return left;
    }

    public int minimumTimeTaken(BinaryTreeNode node, int target) {
        BinaryTreeNode targetNode = getTargetNode(node, target);
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        HashMap<BinaryTreeNode, Boolean> visited = new HashMap<>();
        HashMap<BinaryTreeNode, BinaryTreeNode> parent = new HashMap<>();
        markParent(node, parent);

        int burn = 0;
        queue.offer(targetNode);
        visited.put(targetNode, true);
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                BinaryTreeNode element = queue.poll();

                // check left
                if(element.left != null && visited.get(element.left) == null) {
                    visited.put(element.left, true);
                    queue.add(element.left);
                }
                // check right
                if(element.right != null && visited.get(element.right) == null) {
                    visited.put(element.right, true);
                    queue.add(element.right);
                }
                // check parent
                if(parent.get(element) != null && visited.get(parent.get(element)) == null) {
                    visited.put(parent.get(element), true);
                    queue.add(parent.get(element));
                }
            }

            // update ans
            burn++;
        }

        return burn - 1;
    }


    public static void main(String[] args) {

    }
}
