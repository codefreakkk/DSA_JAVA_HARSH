package trees.codehelp.BinaryTrees;

import java.util.*;

public class ConstructBinaryTreeFromLevelOrder {
    static Scanner sc = new Scanner(System.in);

    public static void levelOrderTraversal(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            BinaryTreeNode element = queue.poll();
            System.out.print(element.data + " ");

            if(element.left != null) queue.offer(element.left);
            if(element.right != null) queue.offer(element.right);
        }
    }

    public static BinaryTreeNode constructBinaryTreeFromLevelOrder(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        System.out.println("Enter data for root node -> ");
        int data = sc.nextInt();
        if(data == -1) return node;
        node = new BinaryTreeNode(data);
        queue.offer(node);

        while(!queue.isEmpty()) {
            BinaryTreeNode element = queue.poll();

            System.out.println("Enter data for left of " + element.data);
            int leftData = sc.nextInt();
            if(leftData != -1) {
                element.left = new BinaryTreeNode(leftData);
                queue.offer(element.left);
            }

            System.out.println("Enter data for right of " + element.data);
            int rightData = sc.nextInt();
            if(rightData != -1) {
                element.right = new BinaryTreeNode(rightData);
                queue.offer(element.right);
            }
        }

        return node;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = null;
        root = constructBinaryTreeFromLevelOrder(root);
        levelOrderTraversal(root);
    }
}
