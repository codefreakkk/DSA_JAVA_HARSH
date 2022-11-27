package recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
    public static int solve(int n, int k, int index, List<Integer> peoples) {
        if(peoples.size() == 1) {
            return peoples.get(0);
        }
        index = (index + k) % peoples.size();
        peoples.remove(index);
        return solve(n, k, index, peoples);
    }

    public static int safePosition(int n, int k) {
        List<Integer> peoples = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            peoples.add(i);
        }
        return solve(n, k - 1, 0, peoples);
    }

    public static void main(String[] args) {
        System.out.println(safePosition(5, 3));
    }
}