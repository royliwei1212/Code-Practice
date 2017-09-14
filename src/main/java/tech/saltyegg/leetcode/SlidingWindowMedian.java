package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new double[0];

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            int x = nums[i];
            queue.add(x);
            populate(maxQueue, minQueue, x);
        }
        double[] result = new double[nums.length - k + 1];
        boolean isOdd = k % 2 != 0;
        int index = 0;
        result[index++] = getMedian(maxQueue, minQueue, isOdd);
        for (int i = k; i < nums.length; i++) {
            Integer toDelete = queue.poll();
            int x = nums[i];
            queue.add(x);
            if (maxQueue.contains(toDelete)) {
                maxQueue.remove(toDelete);
            } else {
                minQueue.remove(toDelete);
            }

            populate(maxQueue, minQueue, x);
            result[index++] = getMedian(maxQueue, minQueue, isOdd);
        }

        return result;
    }

    private double getMedian(PriorityQueue<Integer> maxQueue, PriorityQueue<Integer> minQueue, boolean isOdd) {
        if (isOdd) {
            return minQueue.peek();
        } else {
            return ((long) minQueue.peek() + maxQueue.peek()) / 2.0;
        }
    }

    private void populate(PriorityQueue<Integer> maxQueue, PriorityQueue<Integer> minQueue, int x) {
        if (maxQueue.isEmpty()) {
            minQueue.add(x);
        } else {
            if (x > maxQueue.peek()) {
                minQueue.add(x);
            } else {
                maxQueue.add(x);
            }
        }
        while (minQueue.size() > maxQueue.size() + 1) {
            maxQueue.add(minQueue.poll());
        }
        while (maxQueue.size() > minQueue.size()) {
            minQueue.add(maxQueue.poll());
        }

    }

    public static void main(String[] args) {
        SlidingWindowMedian swm = new SlidingWindowMedian();
        System.out.println(Arrays.toString(swm.medianSlidingWindow(new int[]{1, 4, 2, 3}, 4)));
    }

}
