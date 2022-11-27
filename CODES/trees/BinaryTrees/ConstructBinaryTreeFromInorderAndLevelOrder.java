package trees.BinaryTrees;
import java.util.*;
import java.util.stream.*;



// not solved

public class ConstructBinaryTreeFromInorderAndLevelOrder {
    public int[] find(int[] nums, int[] level) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        List<Integer> ans = new ArrayList<>();
        // check which elements of inorder are present in level order
        for(int i = 0; i < level.length; i++) {
            if(set.contains(level[i])) ans.add(level[i]);
        }

        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) result[i] = ans.get(i);
        return result;
    }

    public BinaryTreeNode solve(int[] inorder, int[] level, HashMap<Integer, Integer> map) {
        if(inorder.length == 0) return null;

        int mid = map.get(inorder[0]);
        BinaryTreeNode root = new BinaryTreeNode(mid);

        int[] left = find(Arrays.copyOfRange(inorder, 0, mid), level);
        int[] right = find(Arrays.copyOfRange(inorder, mid + 1, inorder.length), level);

        root.left = solve(Arrays.copyOfRange(inorder, 0, mid), left, map);
        root.right = solve(Arrays.copyOfRange(inorder, mid + 1, inorder.length), right, map);
        return root;
    }

    public BinaryTreeNode buildTree(int[] inorder, int[] level) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return solve(inorder, level, map);
    }

    public static void main(String[] args) {

    }
}
