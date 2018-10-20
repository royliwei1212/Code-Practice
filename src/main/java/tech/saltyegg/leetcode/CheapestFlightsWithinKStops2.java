package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// out of memory
public class CheapestFlightsWithinKStops2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights == null || flights.length == 0 || K < 0) return -1;
        if (src == dst) return 0;
        Map<Integer, List<Cost>> map = new HashMap<>();
        for (int[] f : flights) {
            List<Cost> list = map.getOrDefault(f[0], new ArrayList<>());
            list.add(new Cost(f[0], f[1], f[2]));
            map.put(f[0], list);
        }
        if (!map.containsKey(src)) return -1;
        int result = Integer.MAX_VALUE;

        Queue<Item> queue = new LinkedList<>();
        for (Cost c : map.get(src)) {
            queue.add(new Item(c.dst, 0, c.cost));
        }

        while (!queue.isEmpty()) {
            Item it = queue.poll();
            if (it.stop > K) continue;
            if (it.src == dst) {
                result = Math.min(result, it.cost);
                continue;
            }
            if (!map.containsKey(it.src)) continue;
            for (Cost c : map.get(it.src)) {
                queue.add(new Item(c.dst, it.stop + 1, it.cost + c.cost));
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }


    static class Cost {
        int src;
        int dst;
        int cost;

        Cost(int s, int d, int c) {
            src = s;
            dst = d;
            cost = c;
        }
    }

    static class Item {
        int src;
        int stop;
        int cost;

        Item(int s, int d, int c) {
            src = s;
            stop = d;
            cost = c;
        }
    }
}
