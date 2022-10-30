package REVISION.trees.BinaryTrees;

import java.util.*;

public class PostorderIterativeUsing2Stack {
    public List<Integer> postorderIterative(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();

        stack1.push(node);
        while(!stack1.isEmpty()) {
            BinaryTreeNode element = stack1.pop();
            stack2.push(element);
            if(element.left != null) stack1.push(element.left);
            if(element.right != null) stack1.push(element.right);
        }

        // find answer
        List<Integer> answer = new ArrayList<>();
        while(!stack2.isEmpty()) answer.add(stack2.pop().data);

        return answer;
    }


    public static void main(String[] args) {

    }
}
