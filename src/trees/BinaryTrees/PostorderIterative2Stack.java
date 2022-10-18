package trees.BinaryTrees;

import java.util.*;

public class PostorderIterative2Stack {
    public List<Integer> postorderTraversal(BinaryTreeNode node) {
        List<Integer> ans = new ArrayList<>();
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        if(node == null) return ans;

        // store element in stack 2 according to postorder
        stack1.push(node);
        while(!stack1.isEmpty()) {
            BinaryTreeNode element = stack1.pop();
            stack2.push(element);

            if(element.left != null) stack1.push(element.left);
            if(element.right != null) stack1.push(element.right);
        }

        // store ans
        while(!stack2.isEmpty()) ans.add(stack2.pop().data);
        return ans;
    }
    public static void main(String[] args) {

    }
}
