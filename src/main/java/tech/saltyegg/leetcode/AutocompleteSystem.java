package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class AutocompleteSystem {

    private TreeMap<String, Integer> map;
    private StringBuilder input;
    private PriorityQueue<Map.Entry<String, Integer>> pq;

    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new TreeMap<>();
        input = new StringBuilder();
        pq = new PriorityQueue<>((o1, o2) -> o2.getValue() == o1.getValue() ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue());
        if (sentences == null || times == null) return;
        for (int i = 0; i < sentences.length; i++) {
            map.put(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            String pre = input.toString();
            map.put(pre, map.getOrDefault(pre, 0) + 1);
            input.setLength(0);
            return Collections.emptyList();
        } else {
            input.append(c);
            String prefix = input.toString();
            pq.clear();
            Map.Entry<String, Integer> start = map.ceilingEntry(prefix);
            while (start != null && start.getKey().startsWith(prefix)) {
                pq.add(start);
                start = map.higherEntry(start.getKey());
            }
            List<String> result = new ArrayList<>();
            int count = 3;
            while (!pq.isEmpty() && count > 0) {
                result.add(pq.poll().getKey());
                count--;
            }
            return result;
        }
    }
}
