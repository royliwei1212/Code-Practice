package tech.saltyegg.leetcode;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] e : edges) {
            int p = e[0] - 1, q = e[1] - 1;
            if (uf.find(p, q)) return e;
            uf.union(p, q);
        }
        return new int[0];
    }

    static class UnionFind {
        int[] root;

        UnionFind(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) root[i] = i;
        }

        int root(int p) {
            while (p != root[p]) {
                root[p] = root[root[p]];
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
