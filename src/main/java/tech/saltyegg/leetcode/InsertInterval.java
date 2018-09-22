/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

import tech.saltyegg.leetcode.parent.Interval;

/**
 * Description:
 *
 * @author hzhou
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        List<Interval> result = new ArrayList<>();

        int idx = 0;
        while (idx < intervals.size() && intervals.get(idx).start < newInterval.start) {
            idx++;
        }
        intervals.add(idx, newInterval);

        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                result.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end); // Modify the element already in list
            }
        }
        return result;
    }
}