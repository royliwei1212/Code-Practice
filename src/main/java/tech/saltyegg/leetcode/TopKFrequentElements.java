package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by hzhou on 2016/5/21.
 * Email: i@hzhou.me
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k < 1) return result;

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> e : map.entrySet()) queue.add(e);
        while (k > 0 && !queue.isEmpty()) {
            result.add(queue.poll().getKey());
            k--;
        }
        return result;
    }

}
