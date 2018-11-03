package tech.saltyegg.leetcode;

public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] r1 = new int[2];
        int[] r2 = new int[2];
        int[] root = new int[edges.length + 1];
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (root[to] == 0) {
                root[to] = from;
            } else {
                r1 = new int[]{root[to], to};
                r2 = new int[]{from, to};
            }
        }

        // check cycle
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (from == r2[0] && to == r2[1]) continue;
            if (uf.find(from, to)) {
                if (r1[0] == 0) return new int[]{from, to};
                else return r1;
            }
            uf.union(to, from);
        }
        return r2;
    }

    static class UnionFind {
        int[] root;

        UnionFind(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) root[i] = i;
        }

        int root(int p) {
            while (p != root[p]) {
                p = root[p];
            }
            return p;
        }

        boolean find(int p, int q) {
            return root(p) == root(q);
        }

        void union(int p, int q) {
            int rp = root(p);
            int rq = root(q);
            root[rp] = rq;
        }
    }
}
