package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hzhou on 2015/5/21.
 * Email: codeashobby@gmail.com
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return result;
        }

        if (intervals.size() == 1) {
            return intervals;
        }

        intervals.sort(Comparator.comparingInt(o -> o.start));

        Interval in = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval crt = intervals.get(i);
            if (in.end >= crt.start) {
                if (in.end < crt.end) {
                    in.end = crt.end;
                }
            } else {
                result.add(in);
                in = crt;
            }
        }
        if (!result.contains(in)) {
            result.add(in);
        }
        return result;
    }

}
