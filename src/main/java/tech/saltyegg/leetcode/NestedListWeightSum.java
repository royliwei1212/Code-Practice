package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.NestedInteger;

import java.util.List;

/**
 * Created by hzhou on 2016/5/14.
 * Email: i@hzhou.me
 */
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return process(nestedList, 1);

    }

    private int process(List<NestedInteger> list, int depth) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                sum += depth * ni.getInteger();
            } else {
                sum += process(ni.getList(), depth + 1);
            }
        }

        return sum;
    }

}
