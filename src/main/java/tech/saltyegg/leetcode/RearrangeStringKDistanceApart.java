package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author hzhou
 * @since 9/12/17
 */
public class RearrangeStringKDistanceApart {

    public String rearrangeString(String s, int k) {
        if (k == 0) return s;
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : s.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            if (!o2.getValue().equals(o1.getValue())) {
                return o2.getValue() - o1.getValue();
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        queue.addAll(dict.entrySet());
        while (!queue.isEmpty()) {
            int min = Math.min(len, k);
            List<Map.Entry<Character, Integer>> tmp = new ArrayList<>();
            for (int i = 0; i < min; i++) {
                if (queue.isEmpty()) return "";
                Map.Entry<Character, Integer> entry = queue.poll();
                int val = entry.getValue() - 1;
                if (val > 0) {
                    entry.setValue(val);
                    tmp.add(entry);
                }

                len--;
                sb.append(entry.getKey());
            }
            queue.addAll(tmp);
        }

        return sb.toString();
    }

}
