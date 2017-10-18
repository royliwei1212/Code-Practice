package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by hzhou on 2016/5/21.
 * Email: i@hzhou.me
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        Arrays.stream(nums).forEach(x -> map.put(x, map.containsKey(x) ? map.get(x) + 1 : 1));
        return map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }

}
