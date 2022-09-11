package StackQueue.queue;

import java.util.*;

public class CircularTour {
    public static int tour(int[] petrol, int[] dist) {
        int deficit = 0; // petrol required
        int start = 0, size = petrol.length, balance = 0;


        for(int i = 0; i < size; i++) {
            balance += petrol[i] - dist[i];

            if(balance < 0) {
                deficit += balance;
                start  = i + 1;
                balance = 0;
            }
        }

        if(deficit + balance >= 0) return start;
        return -1;
    }

    public static void main(String[] args) {
        int[] petrol = {1,2,3,4,5};
        int[] dist = {3,4,5,1,2};

        System.out.println(tour(petrol, dist));
    }
}
