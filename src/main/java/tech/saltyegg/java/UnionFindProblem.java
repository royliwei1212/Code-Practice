package tech.saltyegg.java;

import java.util.ArrayList;
import java.util.List;

// 来自: http://www.cnblogs.com/zmyvszk/p/5351494.html
public class UnionFindProblem {

    /*
     * 网上查了一下：http://blog.csdn.net/dm_vincent/article/details/7655764
     * 这个人写的不错，但是他是抄袭这个普林斯顿的教授的视频：
     * https://www.youtube.com/watch?v=H0bkmI1Xsxg&list=PLe-ggMe31CTexoNYnMhbHaWhQ0dvcy43t&index=2#t=379.668
     * Union Find主要有两个部分，一个部分是Find Query，Check if two objects are in the same component.
     * 另一个部分是Union Command,也就是replace components containing two objects with their union.
     * 那么我们构建一个UF class
     * public class UF
     * UF(int N)------initialize with N object
     * void union(int p,int q)--------add connection between p and q
     * boolean connected(int p,int q)-------are p and q in the same component?
     * 那么如何来构建Data Structure呢？
     * Integer array id[] of size N and p and q are connected iff they have the same id.
     *       0 1  2 3  4  5 6 7 8
     * id[]  0 1  1 8  8  0 0 1 8 8表明0，5，6相连的
     * 那么Find就只需要看id相不相等，然后Union就相对来说比较复杂
     * To Merge components containing p and q, change all entries whose id equals id[p] to id[q].
     * id[]  1 1 1 8 8 1 1 1 8 8       after union of 6 and 1
     */
    public class QuickFindUF {
        private int[] id;

        public QuickFindUF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++)
                id[i] = i;
        }

        public boolean connected(int p, int q) {
            return id[p] == id[q];
        }

        public void union(int p, int q) {
            int pid = id[p];
            int qid = id[q];
            for (int i = 0; i < id.length; i++)
                if (id[i] == pid)
                    id[i] = qid;
        }

        /*
         * 那么我们能不能再把程序更进步一下吗？Quick-Union还是一样的ds，但是，这里id[i] is parent of i,
         * Root of i is id[id[id[..id[i]..]]].Keep going until it doesn't change
         *     0 1 2 3 4 5 6 7 8 9
         * id[]0 1 9 4 9 6 6 7 8 9
         * 0   1    9     6   7   8
         *         / \    |
         *         2 4    5
         *           |
         *           3
         * 这里9，2，4，3在一起
         * check if p and q have the same root
         * Union to merge components containing p and q, set the id of p's root to the id of q's root
         */
        public class QuickUnionUF2 {
            private int[] id;

            public QuickUnionUF2(int N) {
                id = new int[N];
                for (int i = 0; i < N; i++)
                    id[i] = i;
            }

            private int root(int i) {
                while (i != id[i])
                    i = id[i];//一直找到最高的父节点
                return i;
            }

            public boolean connected(int p, int q) {
                return root(p) == root(q);
            }

            public void union(int p, int q) {
                int i = root(p);
                int j = root(q);
                id[i] = j;
            }
        }
    }

    /*
     * 上面两种的比较，
     *           initialize    union    find    defect
     * quick-find    N          N        1      Union too expensive
     * quick-union   N          N        N      Find too expensive,tree are too tall
     * weightd QU    N         lgN      lgN
     * 我们会发现如果用quick union的话树会非常的长，所以我们不能固定模式的union（a，b）一定是把b加到a的子树，我们
     * 应该看ab树的大小，把小的放在大的下面，这样可以节省一部分查找时间
     */
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * 130. Surrounded Regions
     * 2016-4-3 by Mingyang
     * union 什么：所有从边界可达的O元素union在一起
     * union 目的：union完成后那些没有在边界可达O集合中的O是需要翻转的
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int rows = board.length, cols = board[0].length;
        int oRoot = rows * cols;
        initUnionFind(rows * cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') continue;
                int curr = i * cols + j;
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    union(curr, oRoot);
                } else {
                    if (j + 1 < cols && board[i][j + 1] == 'O')
                        union(curr, i * cols + j + 1);
                    if (j - 1 >= 0 && board[i][j - 1] == 'O')
                        union(curr, i * cols + j - 1);
                    if (i + 1 < rows && board[i + 1][j] == 'O')
                        union(curr, (i + 1) * cols + j);
                    if (i - 1 >= 0 && board[i - 1][j] == 'O')
                        union(curr, (i - 1) * cols + j);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && find(i * cols + j) != oRoot) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int[] s;
    int[] rank;

    private void initUnionFind(int n) {
        s = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++)
            s[i] = i;
        rank[n] = n + 1;
    }

    private int find(int p) {
        if (s[p] == p) return p;
        else return s[p] = find(s[p]);
    }

    private void union(int p, int q) {
        int pRoot = find(p), qRoot = find(q);
        if (pRoot == qRoot) return;
        if (rank[pRoot] < rank[qRoot]) {//保证小的树在大的下面
            s[pRoot] = qRoot;
        } else {
            if (rank[pRoot] == rank[qRoot])
                rank[pRoot]++;
            s[qRoot] = pRoot;
        }
    }

    /*
        * 200.Number of Islands
        * 2016-4-3 by Mingyang
        * union 什么：两个相邻的1元素
     * union 目的：union后计数union集合数量（通过计数union数组中根节点数量）
        */
    class UF {
        public int count = 0;
        public int[] id = null;

        public UF(int m, int n, char[][] grid) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') count++;
                }
            }
            id = new int[m * n];
            for (int i = 0; i < m * n; i++) {
                id[i] = i;
            }
        }

        public int find(int p) {
            while (p != id[p]) {
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }

        public boolean isConnected(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) return false;
            else return true;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            id[pRoot] = qRoot;
            count--;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        UF uf = new UF(m, n, grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                int p = i * n + j;
                int q;
                if (i > 0 && grid[i - 1][j] == '1') {
                    q = p - n;
                    uf.union(p, q);
                }
                if (i < m - 1 && grid[i + 1][j] == '1') {
                    q = p + n;
                    uf.union(p, q);
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    q = p - 1;
                    uf.union(p, q);
                }
                if (j < n - 1 && grid[i][j + 1] == '1') {
                    q = p + 1;
                    uf.union(p, q);
                }
            }
        }
        return uf.count;
    }

    //当然你也会觉得下面的可能更简单，那就是另外一种情况了，
    //设一个叫count的值，没遇到一个1，就把所有相连的1全部变为0，这样，到底遇到几次1，就是最终有几个小岛啦
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        // validity checking
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1)
            return;

        // if current cell is water or visited
        if (grid[i][j] != '1')
            return;

        // set visited cell to '0'
        grid[i][j] = '0';

        // merge all adjacent land
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /*
     * 261.Graph Valid Tree
     * 2016-4-3 by Mingyang
     * 我们在Graph里面用其他方法做了一下这里我们再用并查集来做
     * union 什么：一条边的两个顶点
     * union 目的：若union两个顶点时发现根一样，说明已经在同一棵树中，
     * 说明输入graph存在环，非tree；union结束后，计数有多少个不同的根，当且仅当存在一个根时事vaild tree
     */
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            // 如果两个节点已经在同一集合中，说明新的边将产生环路
            if (!uf.union(edges[i][0], edges[i][1])) {
                return false;
            }
        }
        return uf.count() == 1;
    }

    public class UnionFind {
        int[] ids;
        int cnt;

        public UnionFind(int size) {
            this.ids = new int[size];
            //初始化并查集，每个节点对应自己的集合号
            for (int i = 0; i < this.ids.length; i++) {
                this.ids[i] = i;
            }
            this.cnt = size;
        }

        public boolean union(int m, int n) {
            int src = find(m);
            int dst = find(n);
            //如果两个节点不在同一集合中，将两个集合合并为一个
            if (src != dst) {
                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] == src) {
                        ids[i] = dst;
                    }
                }
                // 合并完集合后，集合数减一
                cnt--;
                return true;
            } else {
                return false;
            }
        }

        public int find(int m) {
            return ids[m];
        }

        public int count() {
            return cnt;
        }
    }

    /*
  * 305    Number of Islands II
  * 2016-4-3 by Mingyang
  * Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k ).
  * Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
  * The list pair has k operator and each operator has two integer A[i].x, A[i].y means
  * that you can change the grid matrix[A[i].x][A[i].y] from sea to island.
  * Return how many island are there in the matrix after each operator.
  */
    private int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind2D islands = new UnionFind2D(m, n);
        List<Integer> ans = new ArrayList<Integer>();
        for (int[] position : positions) {
            int x = position[0], y = position[1];
            int p = islands.add(x, y);
            for (int[] d : dir) {
                int q = islands.getID(x + d[0], y + d[1]);
                if (q > 0 && !islands.find(p, q))
                    islands.unite(p, q);
            }
            ans.add(islands.size());
        }
        return ans;
    }
}

class UnionFind2D {
    private int[] id;
    private int[] sz;
    private int m, n, count;

    public UnionFind2D(int m, int n) {
        this.count = 0;
        this.n = n;
        this.m = m;
        this.id = new int[m * n + 1];
        this.sz = new int[m * n + 1];
    }

    public int index(int x, int y) {
        return x * n + y + 1;
    }

    public int size() {
        return this.count;
    }

    public int getID(int x, int y) {
        if (0 <= x && x < m && 0 <= y && y < n)
            return id[index(x, y)];
        return 0;
    }

    public int add(int x, int y) {
        int i = index(x, y);
        id[i] = i;
        sz[i] = 1;
        ++count;
        return i;
    }

    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    public void unite(int p, int q) {
        int i = root(p), j = root(q);
        if (sz[i] < sz[j]) { //weighted quick union
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        --count;
    }

    private int root(int i) {
        for (; i != id[i]; i = id[i])
            id[i] = id[id[i]]; //path compression
        return i;
    }
}
