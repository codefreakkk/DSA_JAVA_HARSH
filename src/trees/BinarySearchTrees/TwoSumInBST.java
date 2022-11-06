package trees.BinarySearchTrees;

import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse = true;
    public BSTIterator(TreeNode node, boolean reverse) {
        this.reverse = reverse;
        pushAll(node);
    }
    public void pushAll(TreeNode node) {
        while(node != null) {
            if(reverse) {
                stack.push(node);
                node = node.left;
            }
            else {
                stack.push(node);
                node = node.right;
            }
        }
    }

    public int next() {
        TreeNode element = stack.pop();
        if(reverse) pushAll(element.right);
        else pushAll(element.left);
        return element.data;
    }

    public boolean hashNext() {
        return !stack.isEmpty();
    }
}

public class TwoSumInBST {
    public boolean findTarget(TreeNode node, int k) {
        BSTIterator after = new BSTIterator(node, true);
        BSTIterator before = new BSTIterator(node, false);

        int afterVal = after.next();
        int beforeVal = before.next();

        while(afterVal < beforeVal) {
            int total = afterVal + beforeVal;
            if(total == k) return true;
            if(total < k) afterVal = after.next();
            else beforeVal  = before.next();
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
