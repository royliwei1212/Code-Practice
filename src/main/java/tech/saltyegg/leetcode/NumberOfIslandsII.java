package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

// Union find
public class NumberOfIslandsII {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0 || m <= 0 || n <= 0) return result;

        QuickUnion qu = new QuickUnion(m * n);
        int[][] dir = new int[][]{
                {1, 0},
                {-1, 0},
                {0, -1},
                {0, 1}
        };
        int count = 0;
        for (int[] pos : positions) {
            int a = pos[0];
            int b = pos[1];
            int cb = a * n + b;
            qu.id[cb] = cb;
            count++;
            for (int[] d : dir) {
                int x = a + d[0];
                int y = b + d[1];
                int nb = x * n + y;
                if (x < 0 || y < 0 || x >= m || y >= n || qu.id[nb] == -1) continue;
                if (!qu.con(cb, nb)) {
                    qu.union(cb, nb);
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    class QuickUnion {

        int[] id;

        QuickUnion(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++) id[i] = -1;
        }

        private int root(int i) {
            while (i != id[i]) i = id[i];
            return i;
        }

        public boolean con(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int ip = root(p);
            int iq = root(q);
            id[ip] = iq;
        }
    }
}
