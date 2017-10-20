package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author hzhou
 * @since 10/19/17
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        int[] count = new int[26];
        for (char c : tasks) count[c - 'A']++;

        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int c : count) {
            if (c != 0) queue.add(c);
        }
        while (!queue.isEmpty()) {
            int cnt = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!queue.isEmpty()) {
                    list.add(queue.poll());
                    cnt++;
                }
            }
            for (int i : list) {
                i--;
                if (i > 0) queue.add(i);
            }
            result += queue.isEmpty() ? cnt : n + 1;
        }
        return result;
    }
}
