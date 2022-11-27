package trees.codehelp.BinaryTrees;

import java.util.*;

public class BurnTree {
    public static void markParent(BinaryTreeNode node, HashMap<BinaryTreeNode, BinaryTreeNode> parent) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            BinaryTreeNode element = queue.poll();
            if(element.left != null) {
                parent.put(element.left, element);
                queue.offer(element.left);
            }
            if(element.right != null) {
                parent.put(element.right, element);
                queue.offer(element.right);
            }
        }
    }

    public static BinaryTreeNode getTargetNode(BinaryTreeNode node, int target) {
        if(node == null || node.data == target) return node;

        BinaryTreeNode left = getTargetNode(node.left, target);
        BinaryTreeNode right = getTargetNode(node.right, target);

        if(left == null) return right;
        return left;
    }

    public static int minTime(BinaryTreeNode node, int target) {
        BinaryTreeNode targetNode = getTargetNode(node, target);
        HashMap<BinaryTreeNode, BinaryTreeNode> parent = new HashMap<>();
        HashMap<BinaryTreeNode, Boolean> visited = new HashMap<>();
        markParent(node, parent);

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(targetNode);

        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                BinaryTreeNode element = queue.poll();
                // move left
                if(element.left != null && visited.get(element.left) == null) {
                    queue.offer(element.left);
                    visited.put(element.left, true);
                }

                // move right
                if(element.right != null && visited.get(element.right) == null) {
                    queue.offer(element.right);
                    visited.put(element.right, true);
                }

                // move up
                if(parent.get(element) != null && visited.get(parent.get(element)) == null) {
                    queue.offer(parent.get(element));
                    visited.put(parent.get(element),true);
                }
            }
            level++;
        }

        return level - 1;
    }


    public static void main(String[] args) {

    }
}
