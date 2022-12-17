package trees.BinaryTrees;

public class RecoverTreeFromPreorder {
    public BinaryTreeNode solve(String str, int level, int[] index) {
        if (index[0] == str.length())
            return null;

        int currentLevel = 0;
        while (str.charAt(index[0] + currentLevel) == '-')
            currentLevel++;

        if (currentLevel == level) {
            index[0] += currentLevel;

            int currentValue = 0;
            while (str.charAt(index[0]) >= '0' && str.charAt(index[0]) <= 9) {
                currentValue = (10 * currentValue) + str.charAt(index[0]) - '0';
                index[0]++;
            }

            BinaryTreeNode root = new BinaryTreeNode(currentValue);
            root.left = solve(str, level + 1, index);
            root.right = solve(str, level + 1, index);
            return root;
        } 
        return null;
    }

    public BinaryTreeNode recoverTreeFromPreorder(String str) {
        return solve(str, 0, new int[] {0});
    }

    public static void main(String[] args) {
        
    }
}
