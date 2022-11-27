package REVISION.trees.BinaryTrees;

import java.util.*;

public class InorderIterative {
    public List<Integer> inorderTraversal(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        if(node == null) return answer;

        while(true) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                if(stack.isEmpty()) break;
                BinaryTreeNode element = stack.pop();
                answer.add(element.data);
                node = element.right;
            }
        }

        return  answer;
    }

    public static void main(String[] args) {

    }
}
