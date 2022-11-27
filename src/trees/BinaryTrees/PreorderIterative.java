package trees.BinaryTrees;

import java.util.*;

public class PreorderIterative {
    // preorder -> root left right
    // TC -> o(N), SC -> o(N)
    public List<Integer> preorderIterative(BinaryTreeNode node) {
        List<Integer> ans = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        if(node == null) return ans;

        stack.push(node);
        while(!stack.isEmpty()) {
            BinaryTreeNode element = stack.pop();
            ans.add(element.data);

            if(element.right != null) stack.push(element.right);
            if(element.left != null) stack.push(element.left);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
