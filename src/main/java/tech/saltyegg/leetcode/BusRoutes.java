package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] r = routes[i];
            for (int n : r) {
                map.putIfAbsent(n, new HashSet<>());
                map.get(n).add(i);
            }
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            while (size-- > 0) {
                int val = queue.poll();
                for (int i : map.get(val)) {
                    if (visited.contains(i)) continue;
                    visited.add(i);
                    for (int k = 0; k < routes[i].length; k++) {
                        if (routes[i][k] == T) return result;
                        queue.add(routes[i][k]);
                    }
                }
            }
        }
        return -1;
    }
}
