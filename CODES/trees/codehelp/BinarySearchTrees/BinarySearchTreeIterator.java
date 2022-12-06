package trees.codehelp.BinarySearchTrees;

import java.util.*;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.data;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {

    }
}
