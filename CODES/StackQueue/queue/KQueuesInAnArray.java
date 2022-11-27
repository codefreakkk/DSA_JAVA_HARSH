package StackQueue.queue;

import java.util.Arrays;

public class KQueuesInAnArray {
    int[] arr, next, front, rear;
    int size, freeSlot = 0;

    public KQueuesInAnArray(int n, int k) {
        arr = new int[n];
        next = new int[n];
        front = new int[k];
        rear = new int[k];
        size = n;

        // update next
        for(int i = 0; i < size; i++) next[i] = i + 1;
        next[size - 1] = -1;

        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);
    }

    public void push(int value, int q) {

        if(freeSlot == -1) {
            System.out.println("Queue full");
            return;
        }

        // get index
        int index = freeSlot;

        // update freeSlot
        freeSlot = next[index];

        // if only one element in queue
        if(front[q - 1] == -1) {
            front[q - 1] = index;
        }
        else {
            // link the element
            next[rear[q - 1]] = index;
        }

        // update freeSlot in next as not occupied
        next[index] = -1;

        // update rear
        rear[q - 1] = index;

        arr[index] = value;

        System.out.println("pushed " + value);
    }

    public int pop(int q) {
        if(front[q - 1] == -1) {
            return -1;
        }

        int index = front[q - 1];

        // update front i.e push front to next value
        front[q - 1] = next[index];

        // since ele pop we have to update free slot
        next[index] = freeSlot;
        freeSlot = index;

        // return element
        return arr[index];
    }

    public int peek(int q) {
        if(front[q - 1] == -1) return -1;
        return arr[front[q - 1]];
    }
    public static void main(String[] args) {
        KQueuesInAnArray q = new KQueuesInAnArray(10, 3);
        q.push(10, 1);
        q.push(15, 1);
        q.push(20, 2);
        q.push(25, 1);

        System.out.println(q.pop(1));
    }
}
