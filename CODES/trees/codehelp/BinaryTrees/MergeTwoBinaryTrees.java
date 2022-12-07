package trees.codehelp.BinaryTrees;

public class MergeTwoBinaryTrees {
    public BinaryTreeNode mergeTrees(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
    
        if(root1 != null && root2 == null) 
            return root1;
    
        if(root1 == null && root2 != null)
            return root2;
    
        root1.data += root2.data;
        
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
    
    public static void main(String[] args) {
        
    }
}
