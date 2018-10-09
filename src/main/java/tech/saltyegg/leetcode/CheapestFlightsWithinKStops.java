package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights == null || flights.length == 0 || flights[0] == null || flights[0].length == 0 || K < 0 || n < 0)
            return -1;

        Queue<Cost> queue = new LinkedList<>();
        queue.add(new Cost(src, 0));
        queue.add(null);

        int result = Integer.MAX_VALUE;

        Map<Integer, List<Cost>> map = new HashMap<>();
        for (int[] f : flights) {
            List<Cost> dest = map.getOrDefault(f[0], new ArrayList<>());
            dest.add(new Cost(f[1], f[2]));
            map.put(f[0], dest);
        }

        int level = 0;
        while (!queue.isEmpty()) {
            Cost node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) queue.add(null);
                level++;
                continue;
            }
            if (level > K || !map.containsKey(node.dest) || node.cost >= result) continue;


            for (Cost c : map.get(node.dest)) {
                if (c.dest == dst) {
                    result = Math.min(result, node.cost + c.cost);
                    continue;
                }
                queue.add(new Cost(c.dest, node.cost + c.cost));
            }


        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }


    static class Cost {
        int dest;
        int cost;

        public Cost(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

}
