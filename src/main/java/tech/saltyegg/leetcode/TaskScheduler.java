package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 10/19/17
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if (n == 0) return tasks.length;

        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            int s = map.getOrDefault(c, 0) + 1;
            max = Math.max(max, s);
            map.put(c, s);
        }
        int count = 0;
        for (int s : map.values()) {
            if (max == s) count++;
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + count);
    }
}
