package trees;

import java.util.*;

public class InorderIterative {
    public List<Integer> inorderIterative(BinaryTreeNode node) {
        List<Integer> ans = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        if(node == null) return ans;

        while(true) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                if(stack.isEmpty()) break;
                BinaryTreeNode element = stack.pop();
                ans.add(element.data);
                node = element.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
