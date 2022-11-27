package trees.BinaryTrees;

import java.util.*;

class Pair {
    int num;
    BinaryTreeNode node;
    public Pair(BinaryTreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class PreorderInorderPostorderIn1Traversal {
    public static void traverse(BinaryTreeNode node) {
        if(node == null) return;
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(node, 1));

        while(!stack.isEmpty()) {
            Pair pair = stack.pop();

            // for preorder
            if(pair.num == 1) {
                pre.add(pair.node.data);
                pair.num++;
                stack.push(pair);

                if(pair.node.left != null) {
                    stack.push(new Pair(pair.node.left, 1));
                }
            }
            // for inorder
            else if(pair.num == 2) {
                inorder.add(pair.node.data);
                pair.num++;
                stack.push(pair);

                if(pair.node.right != null) {
                    stack.push(new Pair(pair.node.right, 1));
                }
            }
            // for postorder
            else {
                post.add(pair.node.data);
            }
        }

        System.out.println("Preorder " + pre);
        System.out.println("Inorder " + inorder);
        System.out.println("Post " + post);
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode(1);
        tree.left = new BinaryTreeNode(2);
        tree.right = new BinaryTreeNode(5);
        tree.left.left = new BinaryTreeNode(3);
        tree.left.right = new BinaryTreeNode(4);
        tree.right.left = new BinaryTreeNode(6);
        tree.right.right = new BinaryTreeNode(7);
        traverse(tree);
    }
}
