package StackQueue.queue;

public class DequeImplementation {
    int[] arr;
    int size, front = -1, rear = -1;

    public DequeImplementation(int k) {
        size = k;
        arr = new int[size];
    }

    // deque function
    public boolean insertFront(int value) {
        // check if deque is full
        if(isFull()) return false;

        if(front == -1) front = rear = 0;
        else if(front == 0 && rear != size - 1) front = size - 1;
        else front--;

        arr[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        // check if deque is full
        if(isFull()) return false;

        if(front == -1) front = rear = 0;
        else if(rear == size - 1 && front != 0) rear = 0;
        else rear++;

        arr[rear] = value;
        return true;
    }

    public boolean deleteFront() {
        // check if deque is empty
        if(isEmpty()) return false;

        if(front == rear) front = rear = -1;
        else if(front == size - 1) front = 0;
        else front++;

        return true;
    }


    // deque function
    public boolean deleteLast() {
        // is empty
        if(isEmpty()) return false;

        if(front == rear) front = rear = -1;
        else if(rear == 0) rear = size - 1;
        else rear--;

        return true;
    }

    public int getFront() {
        if(isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        if(isEmpty()) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {

        if((front == 0 && rear == size - 1) || (front != 0 && rear == (front - 1) % (size - 1))) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        DequeImplementation myCircularDeque = new DequeImplementation(3);
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.getRear());
    }
}
