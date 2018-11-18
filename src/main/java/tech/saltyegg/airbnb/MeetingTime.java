package tech.saltyegg.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

import tech.saltyegg.leetcode.parent.Interval;

public class MeetingTime {

    public List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int x = o1[0] - o2[0];
            return x == 0 ? o1[1] - o2[1] : x;
        });
        for (List<Interval> in : intervals) {
            for (Interval i : in) {
                pq.add(new int[]{i.start, -1});
                pq.add(new int[]{i.end, 1});
            }
        }
        int count = 0;
        List<Interval> result = new ArrayList<>();
        int pre = -1;
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            count += node[1];
            boolean isStart = node[1] < 0;
            int time = node[0];
            if (!isStart && pre == -1 && count == 0) {
                pre = time;
            } else if (isStart && pre != -1 && count == -1) {
                result.add(new Interval(pre, time));
                pre = -1;
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Interval>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(new Interval(1, 3), new Interval(6, 7)));
        intervals.add(Collections.singletonList(new Interval(2, 4)));
        intervals.add(Arrays.asList(new Interval(2, 3), new Interval(9, 12)));

        print(getAvailableIntervals(intervals, 1));

    }

    private void print(List<Interval> intervals) {
        for (Interval i : intervals) {
            System.out.print(i.start + ">" + i.end + " , ");
        }
    }
}
