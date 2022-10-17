package trees;

import java.util.*;

public class BoundaryTraversalOfBinaryTree {
    public boolean isLeaf(BinaryTreeNode node) {
        return node.left == null && node.right == null;
    }
    public void leftNodes(BinaryTreeNode node, ArrayList<Integer> ans) {
        BinaryTreeNode current = node.left;
        while(current != null) {
            if(!isLeaf(current)) ans.add(current.data);
            if(current.left != null) current = current.left;
            else current = current.right;
        }
    }

    public void leafNodes(BinaryTreeNode node, ArrayList<Integer> ans) {
        if(isLeaf(node)) {
            ans.add(node.data);
            return;
        }
        if(node.left != null) leafNodes(node.left, ans);
        if(node.right != null) leafNodes(node.right, ans);
    }

    public void rightNodes(BinaryTreeNode node, ArrayList<Integer> ans) {
        BinaryTreeNode current = node.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while(current != null) {
            if(!isLeaf(current)) temp.add(current.data);
            if(current.right != null) current = current.right;
            else current = current.left;
        }

        // store final answer
        Collections.reverse(temp);
        for(int i = 0; i < temp.size(); i++) ans.add(temp.get(i));
    }

    public ArrayList<Integer> boundaryTraversal(BinaryTreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(ans == null) return ans;
        if(!isLeaf(node)) ans.add(node.data);

        leftNodes(node, ans);
        leafNodes(node, ans);
        rightNodes(node, ans);

        return ans;
    }


    public static void main(String[] args) {

    }
}
