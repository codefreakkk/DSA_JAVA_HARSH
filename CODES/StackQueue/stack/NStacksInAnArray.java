package StackQueue.stack;

import java.util.*;

public class NStacksInAnArray {
    public int[] next;
    public int[] top;
    public int[] arr;
    int n, s, freeSpot, index;

    public NStacksInAnArray(int N, int S) {
        // Write your code here.
        n = N;
        s = S;
        arr = new int[s];
        next = new int[s];
        top = new int[n];

        Arrays.fill(top, -1);
        for(int i = 0; i < s; i++) {
            next[i] = i + 1;
        }
        next[s - 1] = -1;
        freeSpot = 0;
    }

    public boolean push(int x, int m) {
        if(freeSpot == -1) return false;
        // update index
        int index = freeSpot;
        
        // update freespot
        freeSpot = next[index];
        // update new data
        arr[index] = x;
        // update next
        next[index] = top[m - 1];
        // update top
        top[m - 1] = index;
        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        if(top[m - 1] == -1) return -1;
        index = top[m - 1];
        top[m - 1] = next[index];
        next[index] = freeSpot;
        freeSpot = index;
        return arr[index];
    }
}