package tech.saltyegg.leetcode;

import java.util.List;

public class MaximumDistanceInArrays {

    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        int start = arrays.get(0).get(0);
        int end = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> l = arrays.get(i);
            int max = Math.max(Math.abs(l.get(0) - end), Math.abs(l.get(l.size() - 1) - start));
            result = Math.max(result, max);
            start = Math.min(start, l.get(0));
            end = Math.max(end, l.get(l.size() - 1));
        }
        return result;
    }
}
