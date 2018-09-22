package tech.saltyegg.leetcode;

import java.util.List;

import tech.saltyegg.leetcode.parent.NestedInteger;

/**
 * @author hzhou
 * @since 9/14/17
 */
public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int[] val = new int[]{-1, 0};
        return helper(nestedList, val, -1) + ((1 - val[0]) * val[1]);
    }

    private int helper(List<NestedInteger> list, int[] val, int depth) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        int sum = 0;
        val[0] = Math.min(val[0], depth);
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                sum += depth * ni.getInteger();
                val[1] += ni.getInteger();
            } else {
                sum += helper(ni.getList(), val, depth - 1);
            }
        }

        return sum;
    }
}
