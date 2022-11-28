package trees.codehelp.BinarySearchTrees;

public class PredecessorAndSuccessor {
    
    public static TreeNode predecessor(TreeNode current, int key) {
        TreeNode answer = null;
        while(current != null) {
            if(current.data >= key) {
                current = current.left;
            } 
            else {
                answer = current;
                current = current.right;
            }
        }
        return answer;
    } 

    public static TreeNode successor(TreeNode current, int key) {
        TreeNode answer = null;
        while(current != null) {
            if(current.data <= key) {
                current = current.right;
            }
            else {
                answer = current;
                current = current.left;
            }
        }
        return answer;
    }

    public static void findPreAndSuc(TreeNode node, TreeNode p, TreeNode s, int key) {
        TreeNode current = node;
        p = predecessor(current, key);
        s = successor(current, key);
    }

    public static void main(String[] args) {}
}
