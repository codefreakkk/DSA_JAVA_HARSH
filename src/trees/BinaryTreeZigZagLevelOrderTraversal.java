package trees;

import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrderTraversal(BinaryTreeNode node) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        boolean zig = false;
        queue.add(node);
        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> output = new ArrayList<>();

            for(int i = 0; i < level; i++) {
                BinaryTreeNode element = queue.remove();
                if(element != null) {
                    if(element.left != null) queue.add(element.left);
                    if(element.right != null) queue.add(element.right);
                }
                if(element != null) output.add(element.data);
            }

            if(output.size() != 0) {
                if(zig) Collections.reverse(output);
                ans.add(output);
            }
            zig = !zig;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
