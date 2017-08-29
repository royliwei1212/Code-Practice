package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        int result = 0;
        int cursor = 0;
        for (int i = 1; i < intervals.length; i++) {
            Interval crt = intervals[i];
            Interval last = intervals[cursor];
            if (last.end > crt.start) {
                result++;
                if (last.end > crt.end) cursor = i;
            } else {
                cursor = i;
            }
        }
        return result;
    }
}
