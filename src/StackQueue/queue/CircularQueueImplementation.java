package StackQueue.queue;

public class CircularQueueImplementation {
    int[] arr = new int[3];
    int size = arr.length;
    int front = -1, rear = -1;

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        if((front == 0 && rear == size - 1) || (rear == (front - 1) % size)) return true;
        return false;
    }

    public boolean enQueue(int x) {
        if((front == 0 && rear == size - 1) || (rear == (front - 1) % size)) return false;
        else if(front == -1) front = rear = 0;
        else if(rear == size - 1 && front != 0) rear = 0;
        else rear++;

        arr[rear] = x;
        return true;
    }

    public boolean deQueue() {
        // check if queue is empty()
        if(front == -1) return false;

        if(front == rear) front = rear = -1; // if there is single element in queue
        else if(front == size - 1) front = 0; // if front is at last
        else front++; // normal case

        return true;
    }

    public int front() {
        if(isEmpty()) return -1;
        return arr[front];
    }

    public int rear() {
        if(isEmpty()) return -1;
        return arr[rear];
    }

    public static void main(String[] args) {
        CircularQueueImplementation myCircularQueue = new CircularQueueImplementation();
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.rear();     // return 4
    }
}
