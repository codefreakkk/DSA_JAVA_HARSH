package StackQueue.stack;

public class CustomStack {
    public int[] data;
    public static int DEFAULT_SIZE = 10;
    public int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean push(int item) {
        if(isFull()) {
            System.out.println("Stack overflow");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack underflow");
        }
        return data[ptr--];
    }

    public int peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack underflow");
        }
        return data[ptr];
    }
}
