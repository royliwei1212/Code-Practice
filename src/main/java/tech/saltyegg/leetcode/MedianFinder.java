package tech.saltyegg.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hzhou
 * @since 8/17/17
 */
public class MedianFinder {

    private PriorityQueue<Integer> maxQueue;
    private PriorityQueue<Integer> minQueue;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        minQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        minQueue.add(num);
        maxQueue.add(minQueue.poll());

        if (minQueue.size() < maxQueue.size()) {
            minQueue.add(maxQueue.poll());
        }
    }

    public double findMedian() {
        if (minQueue.size() > maxQueue.size()) return minQueue.peek();

        return (minQueue.peek() + maxQueue.peek()) / 2.0;
    }

}
