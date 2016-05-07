package com.codeashobby.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hzhou on 2016/5/6.
 * Email: i@hzhou.me
 */
public class MovingAverage {
    /**
     * Initialize your data structure here.
     */
    private int size;
    private Queue<Integer> queue;

    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        if (queue.size() > this.size) {
            queue.poll();
        }

        int sum = 0;
        for (int i : queue) {
            sum += i;
        }
        return 1.0 * sum / this.size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
