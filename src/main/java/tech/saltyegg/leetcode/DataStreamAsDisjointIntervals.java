package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hzhou
 * @since 9/2/17
 */
public class DataStreamAsDisjointIntervals {

    private List<Interval> result;

    /**
     * Initialize your data structure here.
     */
    public DataStreamAsDisjointIntervals() {
        result = new ArrayList<>();
    }

    public void addNum(int val) {

        Interval in = new Interval(val, val);

        if (result.isEmpty() || val < result.get(0).start - 1 || val > result.get(result.size() - 1).end + 1) {
            result.add(in);
            return;
        }

        if (val == result.get(0).start - 1) {
            result.get(0).start = val;
            return;
        }

        if (val == result.get(result.size() - 1).end + 1) {
            result.get(result.size() - 1).end = val;
            return;
        }

        for (int i = 0; i < result.size(); i++) {
            Interval crt = result.get(i);
            if (crt.start <= val && crt.end >= val) {
                return;
            }

            if (val > crt.end && i < result.size() - 1) {
                Interval next = result.get(i + 1);
                if (val == crt.end + 1) {
                    if (val == next.start - 1) {
                        crt.end = next.end;
                        result.remove(next);
                        i++;
                    } else {
                        crt.end = val;
                    }
                } else {
                    if (val == next.start - 1) {
                        next.start = val;
                    } else if (val < next.start - 1){
                        result.add(in);
                    }
                }
            }
        }

        result.sort(Comparator.comparingInt(o -> o.start));

    }

    public List<Interval> getIntervals() {
        return result;
    }
}
