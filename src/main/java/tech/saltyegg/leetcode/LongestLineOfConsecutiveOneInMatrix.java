package tech.saltyegg.leetcode;

public class LongestLineOfConsecutiveOneInMatrix {

    public int longestLine(int[][] M) {
        int result = 0;
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) return result;

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int x = M[i][j];
                if (x == 0) continue;
                if (!(j > 0 && M[i][j - 1] == 1)) { // to right
                    int k = j;
                    int count = 0;
                    while (k < M[0].length && M[i][k] == 1) {
                        count++;
                        k++;
                    }
                    result = Math.max(result, count);
                }
                if (!(i > 0 && M[i - 1][j] == 1)) { // to down
                    int k = i;
                    int count = 0;
                    while (k < M.length && M[k][j] == 1) {
                        count++;
                        k++;
                    }
                    result = Math.max(result, count);
                }

                if (!(i > 0 && j > 0 && M[i - 1][j - 1] == 1)) { // to right down
                    int m = i;
                    int n = j;
                    int count = 0;
                    while (m < M.length && n < M[0].length && M[m][n] == 1) {
                        count++;
                        m++;
                        n++;
                    }
                    result = Math.max(result, count);
                }

                if (!(i > 0 && j < M[0].length - 1 && M[i - 1][j + 1] == 1)) { // to left down
                    int m = i;
                    int n = j;
                    int count = 0;
                    while (m < M.length && n >= 0 && M[m][n] == 1) {
                        count++;
                        m++;
                        n--;
                    }
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

}
