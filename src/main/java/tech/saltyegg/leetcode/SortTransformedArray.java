package tech.saltyegg.leetcode;

import java.util.PriorityQueue;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class SortTransformedArray {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : nums) {
            queue.add(a * i * i + b * i + c);
        }

        int[] result = new int[nums.length];
        int i = 0;
        while (!queue.isEmpty()) {
            result[i++] = queue.poll();
        }
        return result;
    }
}
