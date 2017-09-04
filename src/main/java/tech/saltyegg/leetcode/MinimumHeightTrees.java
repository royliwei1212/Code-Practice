package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hzhou
 * @since 9/3/17
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        Set<Integer> leaves = new HashSet<>();
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            edgeMap.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            edgeMap.get(a).add(b);
            edgeMap.get(b).add(a);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : edgeMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                leaves.add(entry.getKey());
            }
        }

        // n <= 2 means either node can be root
        while (n > 2) {
            n -= leaves.size();
            Set<Integer> newLeaves = new HashSet<>();
            for (int leaf : leaves) {
                int pair = edgeMap.get(leaf).iterator().next();
                edgeMap.get(pair).remove(leaf);
                if (edgeMap.get(pair).size() == 1) {
                    newLeaves.add(pair);
                }
            }
            leaves = newLeaves;
        }

        return new ArrayList<>(leaves);
    }

}
