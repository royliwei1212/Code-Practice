package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hzhou
 * @since 9/5/17
 */
public class SmallestRange {

    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.isEmpty()) return new int[0];
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int x : nums.get(i)) {
                list.add(new Pair(x, i));
            }
        }
        list.sort(Comparator.comparingInt(o -> o.first));
        Map<Integer, Integer> counter = new HashMap<>();
        int k = 0;
        int start = 0;
        int[] result = new int[2];
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Pair crt = list.get(i);
            if (counter.getOrDefault(crt.second, 0) == 0) {
                k++;
            }
            counter.put(crt.second, counter.getOrDefault(crt.second, 0) + 1);

            while (k == nums.size() && start <= i) {
                if (diff > list.get(i).first - list.get(start).first) {
                    diff = list.get(i).first - list.get(start).first;
                    result = new int[]{list.get(start).first, list.get(i).first};
                }
                int val = counter.get(list.get(start).second) - 1;
                counter.put(list.get(start).second, val);
                if (val == 0) {
                    k--;
                }
                start++;
            }
        }
        return result;
    }

    private static class Pair {
        private Integer first;
        private Integer second;

        Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }

}
