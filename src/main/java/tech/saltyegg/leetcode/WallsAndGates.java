package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/3/17
 */
public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    helper(rooms, i, j, 0);
                }
            }
        }
    }

    private void helper(int[][] rooms, int x, int y, int d) {
        if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] == -1) return;
        if (d == 0 || rooms[x][y] > d) {
            rooms[x][y] = d;
            helper(rooms, x + 1, y, d + 1);
            helper(rooms, x - 1, y, d + 1);
            helper(rooms, x, y + 1, d + 1);
            helper(rooms, x, y - 1, d + 1);
        }
    }

}
