package trees.codehelp.BinaryTrees;

import java.util.*;

// construct binary tree using recursion

public class ConstructBinaryTree {
    Scanner sc = new Scanner(System.in);

    public void levelOrderTraversal(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            BinaryTreeNode element = queue.poll();
            System.out.print(element.data + " ");

            if(element.left != null) queue.offer(element.left);
            if(element.right != null) queue.offer(element.right);
        }
    }

    public BinaryTreeNode buildTree(BinaryTreeNode node) {
        System.out.println("Enter Data -> ");
        int data = sc.nextInt();

        if(data == -1) return null;

        BinaryTreeNode root = new BinaryTreeNode(data);
        System.out.println("Enter data for left of " + root.data);
        root.left = buildTree(root.left);
        System.out.println("Enter data for right of " + root.data);
        root.right = buildTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTree obj = new ConstructBinaryTree();
        BinaryTreeNode root = null;
//        input string -> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        root = obj.buildTree(root);
        obj.levelOrderTraversal(root);
    }
}
