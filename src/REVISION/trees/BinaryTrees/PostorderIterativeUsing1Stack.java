package REVISION.trees.BinaryTrees;

import java.util.*;

public class PostorderIterativeUsing1Stack {
    public List<Integer> postorderIterative(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        stack.push(node);
        BinaryTreeNode current = node;
        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                BinaryTreeNode element = stack.pop().right;
                if(element == null) {
                    BinaryTreeNode temp = stack.pop();
                    ans.add(temp.data);

                    // backtrack
                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        ans.add(stack.pop().data);
                    }
                }
                else current = element;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
