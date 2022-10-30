package REVISION.trees.BinaryTrees;

import java.util.*;

public class PreorderIterative {
    public List<Integer> preorderTraversal(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        if(node == null) return answer;

        stack.push(node);
        while(!stack.isEmpty()) {
            BinaryTreeNode element = stack.pop();
            answer.add(element.data);
            if(element.right != null) stack.push(element.right);
            if(element.left != null) stack.push(element.left);
        }

        return answer;
    }


    public static void main(String[] args) {

    }
}
