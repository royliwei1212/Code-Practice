package tech.saltyegg.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumOfIslands {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        unionFind uf = new unionFind(m * n);
        List<Integer> res = new ArrayList<>();
        for (int[] pos : positions) {
            int cur = pos[0] * n + pos[1];
            uf.ids[cur] = cur;
            uf.count++;
            for (int[] dir : dirs) {
                int x = dir[0] + pos[0];
                int y = dir[1] + pos[1];
                int nb = x * n + y;
                if (x < 0 || x >= m || y < 0 || y >= n || uf.ids[nb] == -1) continue;
                if (uf.find(nb) != uf.find(cur)) {
                    uf.union(nb, cur);
                }
            }
            res.add(uf.count);
        }
        return res;
    }

    public class unionFind {
        int[] ids;
        int count;

        public unionFind(int num) {
            this.ids = new int[num];
            Arrays.fill(ids, -1);
            this.count = 0;
        }

        public int find(int num) {
            return ids[num];
        }

        public boolean union(int n1, int n2) {
            int id1 = ids[n1], id2 = ids[n2];
            if (id1 != id2) {
                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] == id2) {
                        ids[i] = id1;
                    }
                }
                count--;
                return true;
            }
            return false;
        }
    }

    public class unionFind2 { //ids[]记录上一跳pos，root记录最上面的pos,union（i, j）修改i的root的上一跳为j的root
        int[] ids;
        int count;

        public unionFind2(int num) {
            this.ids = new int[num];
            Arrays.fill(ids, -1);
            this.count = 0;
        }

        public int root(int i) { //FIND operation is proportional to the depth of the tree.the average running time is O(logN)
            while (ids[i] != i) i = ids[i];
            return i;
        }

        public boolean isConnected(int i, int j) {
            return root(i) == root(j);
        }

        public void union(int i, int j) {
            int iRoot = root(i);
            int jRoot = root(j);
            ids[iRoot] = jRoot;
        }
    }
}