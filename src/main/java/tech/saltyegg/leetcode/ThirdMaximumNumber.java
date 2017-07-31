package tech.saltyegg.leetcode;

import java.util.PriorityQueue;

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, Integer::compareTo);

        for (int i : nums) {
            if (queue.contains(i)) continue;
            if (queue.size() < 3 || i > queue.peek()) {
                if (queue.size() > 2) {
                    queue.poll();
                }
                queue.add(i);
            }
        }
        if (queue.size() == 3) return queue.poll();
        while (queue.size() > 1) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, Integer::compareTo);
        queue.add(3);
        queue.add(1);
        queue.add(2);
        queue.add(21);
        queue.poll();
        queue.add(-1);
    }

}
