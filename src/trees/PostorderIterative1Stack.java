package trees;

import java.util.*;

public class PostorderIterative1Stack {
    public List<Integer> postorderTraversal(BinaryTreeNode node) {
        List<Integer> ans = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        if(node == null) return ans;

        BinaryTreeNode current = node;
        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                BinaryTreeNode temp = stack.peek().right;
                // if there are no nodes remaining
                if(temp == null) {
                    temp = stack.pop();
                    ans.add(temp.data);
                    // if there are root nodes
                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        ans.add(temp.data);
                    }
                }
                // if there are more nodes remaining
                else current = temp;
            }
        }

        return ans;
    }


    public static void main(String[] args) {

    }
}
