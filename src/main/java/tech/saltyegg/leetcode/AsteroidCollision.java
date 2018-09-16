package tech.saltyegg.leetcode;

import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 2) return asteroids;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int a = asteroids[i];
            if (a > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(a);
            } else if (stack.peek() + a <= 0) {
                if (stack.peek() + a < 0) i--;
                stack.pop();
            }
        }
        int[] result = new int[stack.size()];
        int index = 0;
        for (int s : stack) {
            result[index++] = s;
        }
        return result;
    }


}
