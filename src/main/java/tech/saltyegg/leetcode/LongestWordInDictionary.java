package tech.saltyegg.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String w : words) {
            int len = w.length();
            Set<String> set = map.getOrDefault(len, new TreeSet<>(Comparator.reverseOrder()));
            set.add(w);
            map.put(len, set);
        }
        if (!map.containsKey(1)) return "";
        String result = "";
        for (String s : map.get(1)) {
            Queue<String> queue = new LinkedList<>();
            queue.add(s);
            String max = s;
            while (!queue.isEmpty()) {
                max = queue.poll();
                if (!map.containsKey(max.length() + 1)) continue;
                for (String x : map.get(max.length() + 1)) {
                    if (x.startsWith(max)) queue.add(x);
                }
            }
            if (max.length() > result.length() || max.length() == result.length() && max.compareTo(result) < 0)
                result = max;
        }

        return result;
    }
}
