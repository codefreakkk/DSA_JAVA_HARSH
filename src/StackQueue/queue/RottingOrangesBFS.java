package StackQueue.queue;

import java.util.*;

public class RottingOrangesBFS {
    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;

        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0, fresh = 0, n = grid.length, m = grid[0].length, min = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != 0) fresh++;

                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if(fresh == 0) return 0;

        // 4 directions
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt += size;

            // loop for removing oranges from queue
            for(int i = 0; i < size; i++) {
                int[] rotton = queue.poll();

                // loop for check all 4 directions
                for(int j = 0; j < 4; j++) {
                    int x = rotton[0] + dx[j];
                    int y = rotton[1] + dy[j];

                    // if x and y are out of boundaries then continue
                    if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 2 || grid[x][y] == 0) {
                        continue;
                    }

                    // mark as rotton
                    grid[x][y] = 2;

                    // add new rotton orange in queue
                    queue.offer(new int[]{x, y});
                }
            }

            // if queue is not empty that means it has some oranges
            if(!queue.isEmpty()) min++;
        }
        return fresh == cnt ? min : -1;
    }

    public static void main(String[] args) {
        int[][] nums = {{2,1,1},{1, 1, 0},{0,1,1}};

        System.out.println(orangesRotting(nums));
    }
}
