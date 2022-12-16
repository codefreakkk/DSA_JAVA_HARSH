package array;

import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double r1 = (double) a.value / (double) a.weight;
        double r2 = (double) b.value / (double) b.weight;
        if (r1 < r2)
            return 1;
        else if (r1 > r2)
            return -1;
        else
            return 0;
    }
}

public class FractionalKnapsack {
    public static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new ItemComparator());
        int currentWeight = 0;
        double finalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (currentWeight + arr[i].weight <= W) {
                currentWeight += arr[i].weight;
                finalValue += arr[i].value;
            } else {
                int remain = W - currentWeight;
                finalValue += (arr[i].value / arr[i].weight) * remain;
                break;
            }
        }
        return finalValue;
    }

    public static void main(String[] args) {
        int n = 3;
        int w = 50;
        Item[] arr = new Item[n];
        System.out.println(fractionalKnapsack(50, arr, n));
    }
}
