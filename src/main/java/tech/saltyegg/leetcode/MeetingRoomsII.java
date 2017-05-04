/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

import tech.saltyegg.leetcode.parent.Interval;
import org.junit.Test;

/**
 * Description:
 *
 * @author hzhou
 */
public class MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            int r = o1.start - o2.start;
            return r == 0 ? o1.end - o2.end : r;
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            int val = queue.peek();
            Interval in = intervals[i];
            if (in.start >= val) {
                queue.remove(val);
            }
            queue.add(in.end);
        }
        return queue.size();
    }

    @Test
    public void test() {
        Interval[] intervals = new Interval[]{new Interval(5, 8), new Interval(6, 8)};
        System.out.println(minMeetingRooms(intervals));

    }
}