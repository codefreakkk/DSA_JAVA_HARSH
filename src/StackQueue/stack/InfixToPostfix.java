package StackQueue.stack;

import java.util.Stack;

public class InfixToPostfix {
    public static int precedence(char ch) {
        if(ch == '/' || ch == '*') return 2;
        if(ch == '+' || ch == '-') return 1;
        return 3;
    }

    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        String answer = "";
        int size = s.length();

        for(int i = 0; i < size; i++) {
            char item = s.charAt(i);
            if(Character.isLetter(item)) answer += item;
            else {
                if(!stack.isEmpty() && precedence(item) > precedence(stack.peek())) stack.push(item);
                else {
                    while(!stack.isEmpty() && precedence(item) <= precedence(stack.peek())) {
                        if(!stack.isEmpty()) answer += stack.pop();
                    }
                    stack.push(item);
                }
            }
        }
        if(stack.size() > 0) {
            while(stack.size() != 0) answer += stack.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "x+y*z";
        System.out.println(infixToPostfix(s));
    }

    public static class CircularQueue {
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
    }
}
