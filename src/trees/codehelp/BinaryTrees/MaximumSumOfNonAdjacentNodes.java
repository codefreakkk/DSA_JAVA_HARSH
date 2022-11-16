package trees.codehelp.BinaryTrees;

public class MaximumSumOfNonAdjacentNodes {
    class Pair {
        int include;
        int exclude;
        public Pair() {}
        public Pair(int include, int exclude) {
            this.include = include;
            this.exclude = exclude;
        }
    }

    public Pair solve(BinaryTreeNode node) {
        if(node == null) return new Pair(0, 0);

        Pair left = solve(node.left);
        Pair right = solve(node.right);

        // compute pairs
        Pair pair = new Pair();
        pair.include = node.data + left.exclude + right.exclude;
        pair.exclude = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);

        return pair;
    }

    public int getMaxSum(BinaryTreeNode node) {
        Pair pair = solve(node);
        return Math.max(pair.include, pair.exclude);
    }

    public static void main(String[] args) {

    }
}
