package Hashing;

import java.util.Arrays;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class JobSequencingProblem {

    public static int[] jobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int max = 0;
        for(int i  = 0; i < n; i++) {
            if(arr[i].deadline > max) max = arr[i].deadline;
        }

        int[] result = new int[max + 1];
        Arrays.fill(result, -1);
        int cnt = 0, sum = 0;

        for(int i = 0; i < n; i++) {
            for(int j = arr[i].deadline; j > 0; j--) {
                if(result[j] == -1) {
                    sum += arr[i].profit;
                    cnt++;
                    result[j] = arr[i].id;
                    break;
                }
            }
        }

        int ans[] = {cnt, sum};
        return ans;
    }


    public static void main(String[] args) {
        Job[] arr = new Job[5];
        int[] ans = jobScheduling(arr, arr.length);
    }
}
