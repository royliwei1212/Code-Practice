package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/14/17
 */
public class FriendCircles {

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;

        int result = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i]) continue;
            result++;
            helper(M, i, visited);
        }

        return result;

    }

    private void helper(int[][] M, int start, boolean[] visited) {
        visited[start] = true;

        for (int i = 0; i < M.length; i++) {
            if (M[start][i] == 0 || visited[i]) continue;
            helper(M, i, visited);
        }
    }
}
