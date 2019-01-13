package tech.saltyegg.leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import tech.saltyegg.leetcode.parent.Pair;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        if (deadends != null) {
            Collections.addAll(set, deadends);
        }

        if (set.contains("0000") || set.contains(target)) return -1;

        Set<String> visited = new HashSet<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>("0000", 0));
        visited.add("0000");
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            if (pair.getKey().equals(target)) return pair.getValue();
            String val = pair.getKey();
            for (int i = 0; i < val.length(); i++) {
                int x = val.charAt(i) - '0';
                String left = val.substring(0, i);
                String right = val.substring(i + 1);
                String s1 = left + ((x + 11) % 10) + right;
                if (!set.contains(s1) && !visited.contains(s1)) {
                    queue.add(new Pair<>(s1, pair.getValue() + 1));
                    visited.add(s1);
                }
                String s2 = left + ((x + 9) % 10) + right;
                if (!set.contains(s2) && !visited.contains(s2)) {
                    queue.add(new Pair<>(s2, pair.getValue() + 1));
                    visited.add(s2);
                }
            }

        }
        return -1;
    }
}
