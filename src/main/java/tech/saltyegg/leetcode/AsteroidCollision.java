package tech.saltyegg.leetcode;

import org.junit.Test;

import javafx.util.Pair;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 2) return asteroids;
        int l = 0;
        while (l < asteroids.length) {

            if (asteroids[l] > 0) {
                Pair<Boolean, Integer> pair = isNextNeg(asteroids, l + 1);
                if (pair.getKey()) {
                    int sum = asteroids[l] + asteroids[pair.getValue()];
                    if (sum == 0) {
                        asteroids[l] = asteroids[pair.getValue()] = 0;
                    } else if (sum > 0) {
                        asteroids[pair.getValue()] = 0;
                    } else {
                        asteroids[l] = 0;
                    }
                    l = -1;
                }
            }
            l++;
        }
        int len = 0;
        for (int i : asteroids) {
            if (i != 0) len++;
        }
        int[] result = new int[len];
        int index = 0;
        for (int i : asteroids) {
            if (i != 0) {
                result[index++] = i;
            }
        }
        return result;
    }

    private Pair<Boolean, Integer> isNextNeg(int[] asteroids, int start) {
        while (start < asteroids.length && asteroids[start] == 0) {
            start++;
        }
        return new Pair<>(start < asteroids.length && asteroids[start] < 0, start);
    }

    @Test
    public void test() {
        asteroidCollision(new int[]{10, 2, -5});
    }
}
