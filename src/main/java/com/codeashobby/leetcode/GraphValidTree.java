package com.codeashobby.leetcode;

import java.util.HashMap;
import java.util.Map;

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

}
