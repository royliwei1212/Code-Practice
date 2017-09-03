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

}
