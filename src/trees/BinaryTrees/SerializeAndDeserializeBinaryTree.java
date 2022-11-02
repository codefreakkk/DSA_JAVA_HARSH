package trees.BinaryTrees;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    public String serialize(BinaryTreeNode node) {
        if(node == null) return "";
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        queue.offer(node);
        while(!queue.isEmpty()) {
            BinaryTreeNode element = queue.poll();
            if(element == null) {
                res.append("n ");
                continue;
            }
            res.append(element.data + " ");
            queue.offer(element.left);
            queue.offer(element.right);
        }

        return res.toString();
    }

    public BinaryTreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");

        BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        for(int i = 1; i < values.length; i++) {
            BinaryTreeNode element = queue.poll();
            if(!values[i].equals("n")) {
                BinaryTreeNode left = new BinaryTreeNode(Integer.parseInt(values[i]));
                element.left = left;
                queue.offer(left);
            }
            if(!values[++i].equals("n")) {
                BinaryTreeNode right = new BinaryTreeNode(Integer.parseInt(values[i]));
                element.right = right;
                queue.offer(right);
            }
        }

        return root;
    }


    public static void main(String[] args) {

    }
}
