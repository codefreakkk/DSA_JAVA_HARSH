package trees.codehelp.BinaryTrees;

class Pair {
    int data = 0;
    boolean flag = false;
    public Pair(int data, boolean flag) {
        this.data = data;
        this.flag = flag;
    }
}

public class SumTree {
    public Pair solve(BinaryTreeNode node) {
        if(node == null) return new Pair(0, true);
        if(node.left == null && node.right == null) return new Pair(node.data, true);

        Pair left = solve(node.left);
        Pair right = solve(node.right);

        // if any of sub tree is not satisfying given condition
        if(left.flag == false || right.flag == false) return new Pair(0, false);

        if(node.data != left.data + right.data) return new Pair(node.data + left.data + right.data, false);
        return new Pair(node.data + left.data + right.data, true);
    }

    public boolean isSumTree(BinaryTreeNode node) {
        Pair pair = solve(node);
        return pair.flag;
    }


    public static void main(String[] args) {

    }
}
