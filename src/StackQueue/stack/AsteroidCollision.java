package StackQueue.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroid) {
        int size = asteroid.length;
        boolean vanished = false;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < size; i++) {
            vanished = false;
            while(!stack.isEmpty() && asteroid[i] < 0 && stack.peek() > 0) {
                if(stack.peek() > Math.abs(asteroid[i])) {
                    vanished = true;
                    break;
                } else if(stack.peek() == Math.abs(asteroid[i])) {
                    stack.pop();
                    vanished = true;
                    break;
                }
                else stack.pop();
            }

            if(!vanished) {
                stack.push(asteroid[i]);
            }
        }

        int[] ans = new int[stack.size()];
        int i = stack.size() - 1;
        while(!stack.isEmpty()) {
            ans[i--] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ans = {-2,1,-1,-2};
        int[] nums = asteroidCollision(ans);

        System.out.println("output is " + Arrays.toString(nums));
    }
}
