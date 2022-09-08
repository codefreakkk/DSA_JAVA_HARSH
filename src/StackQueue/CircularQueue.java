package StackQueue;

public class CircularQueue {
    public int[] data;
    public static int default_size = 5;
    public int front = 0;
    public int back = 0;
    public int size = 0;

    public CircularQueue() {
        this(default_size);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) {
        if(isFull()) {
            System.out.println("Queue full");
            return false;
        }
        data[back++] = item;
        back %= data.length;
        size++;
        return true;
    }

    public int remove() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue empty");
        }
        int removed = data[front++];
        front %= data.length;
        size--;
        return removed;
    }

    public int front() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue empty");
        }
        return data[front];
    }

    public void display() {
        if(isEmpty()) System.out.println("Queue empty");
        int i = front;

        do {
            System.out.println(data[i]);
            i++;
            i %= data.length;
        } while(i != back);
    }

    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(3);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.remove();
        queue.display();
    }
}
