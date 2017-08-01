package tech.saltyegg.leetcode;

import java.util.List;

public class MaximumDistanceInArrays {

    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < arrays.size(); i++) {
            int max = Integer.MIN_VALUE;
            List<Integer> li = arrays.get(i);
            for (int j = 0; j < arrays.size(); j++) {
                if (i != j) {
                    List<Integer> lj = arrays.get(j);
                    max = Math.max(max, lj.get(lj.size() - 1) - li.get(0));
                }
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
