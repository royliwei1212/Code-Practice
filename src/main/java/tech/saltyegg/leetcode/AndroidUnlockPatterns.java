package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/1/17
 * <p>
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 */
public class AndroidUnlockPatterns {

    public int numberOfPatterns(int m, int n) {
        int[][] dict = new int[10][10];
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                dict[i][j] = 0;
            }
        }
        dict[1][3] = dict[3][1] = 2;
        dict[1][7] = dict[7][1] = 4;
        dict[4][6] = dict[6][4] = 5;
        dict[2][8] = dict[8][2] = 5;
        dict[7][9] = dict[9][7] = 8;
        dict[3][9] = dict[9][3] = 6;
        dict[1][9] = dict[9][1] = dict[3][7] = dict[7][3] = 5;

        boolean[] visited = new boolean[10];
        for (int i = 1; i < 10; i++) {
            visited[i] = false;
        }

        int result = 0;
        result += 4 * helper(m, n, dict, visited, 1, 0, 1);
        result += 4 * helper(m, n, dict, visited, 2, 0, 1);
        result += helper(m, n, dict, visited, 5, 0, 1);
        return result;

    }

    private int helper(int m, int n, int[][] dict, boolean[] visited, int start, int result, int length) {
        if (length >= m) {
            result++;
        }
        if (length >= n) {
            return result;
        }

        visited[start] = true;
        for (int i = 1; i < 10; i++) {
            int x = dict[start][i];
            if (!visited[i] && (x == 0 || visited[x])) {
                result = helper(m, n, dict, visited, i, result, length + 1);
            }
        }
        visited[start] = false;

        return result;
    }

}
