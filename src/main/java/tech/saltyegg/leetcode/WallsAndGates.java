package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/3/17
 */
public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(i + 1, j, 1, rooms);
                    dfs(i - 1, j, 1, rooms);
                    dfs(i, j + 1, 1, rooms);
                    dfs(i, j - 1, 1, rooms);
                }
            }
        }

    }


    private void dfs(int x, int y, int val, int[][] rooms) {
        if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length) return;

        if (rooms[x][y] > val) {
            rooms[x][y] = val;
            dfs(x + 1, y, val + 1, rooms);
            dfs(x - 1, y, val + 1, rooms);
            dfs(x, y + 1, val + 1, rooms);
            dfs(x, y - 1, val + 1, rooms);
        }
    }

}
