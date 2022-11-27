package trees.BinaryTrees;

import java.util.*;

public class PostorderIterative1Stack {
    public List<Integer> postorderTraversal(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(node == null) return ans;

        BinaryTreeNode current = node;
        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                BinaryTreeNode temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.pop();
                    ans.add(temp.data);

                    // backtrack
                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        ans.add(temp.data);
                    }
                }
                else current = temp;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
