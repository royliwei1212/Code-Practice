package tech.saltyegg.leetcode;

public class ConstructQuadTree {

    public Node construct(int[][] grid) {
        return helper(0, 0, grid.length, grid);
    }

    private Node helper(int sl, int st, int len, int[][] grid) {
        if (sameVal(sl, st, len, grid)) {
            return new Node(grid[sl][st] == 1, true, null, null, null, null);
        } else {
            Node node = new Node(false, false, null, null, null, null);
            int half = len / 2;
            node.topLeft = helper(sl, st, half, grid);
            node.bottomLeft = helper(sl + half, st, half, grid);
            node.topRight = helper(sl, st + half, half, grid);
            node.bottomRight = helper(sl + half, st + half, half, grid);
            return node;
        }
    }

    private boolean sameVal(int sl, int st, int len, int[][] grid) {
        int val = grid[sl][st];
        for (int i = sl; i < sl + len; i++) {
            for (int j = st; j < st + len; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}

