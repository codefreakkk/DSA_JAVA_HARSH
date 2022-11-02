package trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversalPreorder {
    public List<Integer> preorderTraversal(BinaryTreeNode node) {
        List<Integer> ans = new ArrayList<>();
        if(node == null) return ans;

        BinaryTreeNode current = node;
        while(current != null) {
            if(current.left == null) {
                ans.add(current.data);
                current = current.right;
            }
            else {
                BinaryTreeNode prev = current.left;
                while(prev.right != null && prev.right != current) prev = prev.right;
                if(prev.right == null) {
                    prev.right = current;
                    ans.add(current.data);
                    current = current.left;
                }
                else {
                    prev.right = null;
                    current = current.right;
                }
            }
        }

        return ans;
    }
}
