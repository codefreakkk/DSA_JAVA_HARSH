package StackQueue.queue;

public class CustomQueue {
    public int[] data;
    public static int size = 5;
    public int ptr = -1;

    public CustomQueue() {
        this(size);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public boolean push(int item) {
        if(isFull()) {
            System.out.println("Queue full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int remove() throws Exception {
        if(isEmpty()) throw new Exception("Queue underflow");

        int removed = data[0];
        for(int i = 1; i <= ptr; i++) {
            data[i - 1] = data[i];
        }
        ptr--;
        return removed;
    }

    public static void main(String[] args) throws Exception{
        CustomQueue queue = new CustomQueue(2);
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println(queue.remove());
    }
}
