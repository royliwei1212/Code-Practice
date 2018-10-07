package tech.saltyegg.code;

public class QuickUnion {

    private int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
    }

    private int root(int i) {
        while (i != id[i]) {
            // id[i] = id[id[i]]; // path compression
            i = id[i];
        }
        return i;
    }

    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        id[pid] = qid;

    }
}

