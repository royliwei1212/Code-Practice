package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author hzhou
 * @since 9/2/17
 */
public class DataStreamAsDisjointIntervals {

    private TreeSet<Interval> treeSet;

    /**
     * Initialize your data structure here.
     */
    public DataStreamAsDisjointIntervals() {
        treeSet = new TreeSet<>(Comparator.comparingInt(o -> o.start));
    }

    public void addNum(int val) {

        Interval in = new Interval(val, val);

        Interval floor = treeSet.floor(in);
        Interval ceiling = treeSet.ceiling(in);

        if (treeSet.isEmpty()) {
            treeSet.add(in);
            return;
        }
        if (floor == ceiling) return;

        if (floor == null) {
            if (val == ceiling.start) {
                return;
            } else if (ceiling.start == val + 1) {
                in.end = ceiling.end;
                treeSet.remove(ceiling);
            }
            treeSet.add(in);

        } else if (ceiling == null) {
            if (val <= floor.end) {
                return;
            }

            if (floor.end == val - 1) {
                in.start = floor.start;
                treeSet.remove(floor);
            }
            treeSet.add(in);

        } else {

            if (val <= floor.end || val == ceiling.start) return;

            if (val == floor.end + 1 || val == ceiling.start - 1) {
                if (val == floor.end + 1) {
                    in.start = floor.start;
                    treeSet.remove(floor);
                } else if (val == ceiling.start - 1) {
                    in.end = ceiling.end;
                    treeSet.remove(ceiling);
                }

            }
            treeSet.add(in);

        }

    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(treeSet);
    }
}
