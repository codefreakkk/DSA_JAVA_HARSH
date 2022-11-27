package trees.BinaryTrees;

import java.util.*;

public class FlattenABinaryTreeToLinkedList {
//    Approach 1 using recursion TC - o(N), SC - o(N)
    BinaryTreeNode prev = null;
    public void flatten1(BinaryTreeNode node) {
        if(node == null) return;

        flatten1(node.right);
        flatten1(node.left);

        // make connections
        node.right = prev;
        node.left = null;
        prev = node;
    }

//    Approach 2 using stack TC - o(N), SC - o(N)
    public void flatten2(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            BinaryTreeNode current = stack.pop();
            if(current.right != null) stack.push(current.right);
            if(current.left != null) stack.push(current.left);
            if(!stack.isEmpty()) current.right = stack.peek();
            current.left = null;
        }
    }

//  Optimized Approach TC - o(N), SC - o(1)
    public void flatten(BinaryTreeNode node) {
        if(node == null) return;
        BinaryTreeNode current = node;
        while(current != null) {
            if(current.left != null) {
                BinaryTreeNode prev = current.left;
                while(prev.right != null) prev = prev.right;
                prev.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    public static void main(String[] args) {

    }
}
