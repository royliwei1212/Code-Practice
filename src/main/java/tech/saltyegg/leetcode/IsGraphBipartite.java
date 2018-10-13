package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return false;

        Boolean[] dp = new Boolean[graph.length];

        for (int m = 0; m < dp.length; m++) {
            if (dp[m] != null) continue;
            dp[m] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(m);
            while (!queue.isEmpty()) {
                int i = queue.poll();
                for (int n : graph[i]) {
                    if (dp[n] == null) {
                        dp[n] = !dp[i];
                        queue.add(n);
                        continue;
                    }
                    if (dp[n] == dp[i]) return false;
                }
            }
        }
        return true;
    }
}
