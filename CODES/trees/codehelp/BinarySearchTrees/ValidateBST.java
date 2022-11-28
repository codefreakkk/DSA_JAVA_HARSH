package trees.codehelp.BinarySearchTrees;

public class ValidateBST {
    
    public boolean solve(TreeNode node, int minValue, int maxValue) {
        if(node == null) return true;
        if(!(node.data >= minValue && node.data <= maxValue)) return false;
    
        boolean left = solve(node.left, minValue, node.data);
        boolean right = solve(node.right, node.data, maxValue);
        
        return left && right;
    }
    
    public boolean isValidBST(TreeNode node) {
        boolean answer = solve(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return answer;
    }
    
    public static void main(String[] args) {}
}
