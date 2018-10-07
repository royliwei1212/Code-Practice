package tech.saltyegg.code;

public class QuickFind {

    private int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
    }

    public boolean find(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = id[q];
        }
    }
}

