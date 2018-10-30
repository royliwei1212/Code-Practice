package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] r : routes) {
            Set<Integer> set = toSet(r);
            for (int i : r) {
                map.putIfAbsent(i, new HashSet<>());
                map.get(i).addAll(set);
            }
        }

        Set<Integer> visited = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(S, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (T == node.val) return node.level;
            if (!map.containsKey(node.val)) continue;
            for (int i : map.get(node.val)) {
                if (visited.contains(i)) continue;
                queue.add(new Node(i, node.level + 1));
                visited.add(i);
            }
        }
        return -1;
    }

    private Set<Integer> toSet(int[] r) {
        Set<Integer> result = new HashSet<>();
        for (int i : r) result.add(i);
        return result;
    }

    static class Node {
        int val;
        int level;

        Node(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }
}
