package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null || words1.length == 0 || words2.length == 0) return true;
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] p : pairs) {
            String a = p[0];
            String b = p[1];
            Set<String> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
            set = map.getOrDefault(b, new HashSet<>());
            set.add(a);
            map.put(b, set);
        }

        for (int i = 0; i < words1.length; i++) {
            String a = words1[i];
            String b = words2[i];
            if (a.equals(b) || contains(map, a, b)) continue;
            return false;
        }
        return true;
    }

    private boolean contains(Map<String, Set<String>> map, String s, String t) {
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);
        while (!queue.isEmpty()) {
            String x = queue.poll();
            if (!map.containsKey(x)) continue;
            if (map.get(x).contains(t)) return true;
            for (String m : map.get(x)) {
                if (!visited.contains(m)) queue.add(m);
            }
            visited.add(x);

        }
        return false;
    }
}
