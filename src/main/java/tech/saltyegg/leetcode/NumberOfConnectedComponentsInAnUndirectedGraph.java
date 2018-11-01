package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hzhou
 * @since 9/2/17
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> dict = new HashMap<>();

        for (int[] e : edges) {
            int start = e[0];
            int end = e[1];
            List<Integer> list = dict.getOrDefault(start, new ArrayList<>());
            list.add(end);
            dict.put(start, list);

            list = dict.getOrDefault(end, new ArrayList<>());
            list.add(start);
            dict.put(end, list);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                dfs(i, dict, visited);
            }
        }

        return result;
    }

    private void dfs(int num, Map<Integer, List<Integer>> dict, boolean[] visited) {
        if (visited[num]) return;
        visited[num] = true;

        if (!dict.containsKey(num)) return;
        for (int x : dict.get(num)) {
            dfs(x, dict, visited);
        }
    }

    public int countComponents2(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] e : edges) uf.union(e[0], e[1]);
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (uf.root[i] == i) result++;
        }
        return result;
    }

    static class UnionFind {
        int[] root;

        UnionFind(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) root[i] = i;
        }

        int root(int p) {
            while (p != root(p)) {
                root[p] = root[root[p]];
                p = root(p);
            }
            return p;
        }

        boolean find(int p, int q) {
            return root(p) == root(q);
        }

        void union(int p, int q) {
            int ip = root(p);
            int iq = root(q);
            root[ip] = iq;
        }
    }

}
