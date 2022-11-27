package trees.codehelp.BinarySearchTrees;

import java.util.*;

public class ConstructBinarySearchTree {

    public static void levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode element = queue.poll();
                System.out.print(element.data + " ");
                if(element.left != null) queue.offer(element.left);
                if(element.right != null) queue.offer(element.right);
            }
        }
    }

    public static void inorder(TreeNode node) {
        if(node == null) return;

        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    public static TreeNode insertIntoBST(TreeNode node, int data) {
        if (node == null) {
            TreeNode root = new TreeNode(data);
            return root;
        }

        if (data < node.data)
            node.left = insertIntoBST(node.left, data);
        else
            node.right = insertIntoBST(node.right, data);

        return node;
    }

    public static TreeNode buildTree(TreeNode node) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter node value");
        int data = sc.nextInt();

        while (data != -1) {
            node = insertIntoBST(node, data);
            data = sc.nextInt();

        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode node = null;
        TreeNode root = buildTree(node);
        // levelOrderTraversal(root);
        inorder(root);
    }

}
