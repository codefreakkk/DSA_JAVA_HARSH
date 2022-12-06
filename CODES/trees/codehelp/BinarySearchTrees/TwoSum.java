package trees.codehelp.BinarySearchTrees;

import java.util.*;

class BSTIterator {
    Stack<TreeNode> stack;
    boolean reverse = false;

    public BSTIterator(TreeNode node, boolean reverse) {
        stack = new Stack<>();
        this.reverse = reverse;
        pushAll(node);
    }

    public int next() {
        TreeNode node = stack.pop();
        if (!reverse) {
            pushAll(node.right);
        }
        else {
            pushAll(node.left);
        }
        return node.data;
    }

    public void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (!reverse) {
                node = node.left;
            }
            else {
                node = node.right;
            }
        }
    }
}

public class TwoSum {
    public boolean findTarget(TreeNode node, int k) {
        BSTIterator after = new BSTIterator(node, false);
        BSTIterator before = new BSTIterator(node, true);

        int i = after.next();
        int j = before.next();
        while (i < j) {
            int total = i + j;
            if (total == k) 
                return true;
            else if (total < k) 
                i = after.next();
            else 
                j = before.next();
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
