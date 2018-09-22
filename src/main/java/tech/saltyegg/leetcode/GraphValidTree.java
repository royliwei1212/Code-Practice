package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by hzhou on 2016/5/8.
 * Email: i@hzhou.me
 */
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (n < 1 || edges.length != n - 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, i);
        }

        for (int[] edge : edges) {
            int a = findRoot(map, edge[0]);
            int b = findRoot(map, edge[1]);
            if (a == b) {
                return false;
            }
            map.put(b, a);
        }
        return true;
    }

    private int findRoot(Map<Integer, Integer> map, int val) {
        int root = map.get(val);
        if (root == val) {
            return root;
        } else {
            return findRoot(map, root);
        }
    }

    public boolean validTree2(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        Set<Integer> visited = new HashSet<>();
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited.add(1);
        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            for (int y : map.get(x)) {
                if (visited.contains(y)) return false;
                queue.add(y);
                visited.add(y);
                map.get(y).remove(x);
            }
        }
        return visited.size() == n;
    }

}
