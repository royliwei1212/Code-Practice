package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 8/27/17
 */
public class BeautifulArrangement {

    public int countArrangement(int N) {
        if (N < 1) return 0;

        int[] result = {0};
        int[] visited = new int[N + 1];

        help(N, 1, visited, result);
        return result[0];
    }

    private void help(int N, int start, int[] visited, int[] result) {
        if (start > N) {
            result[0]++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0 && (start % i == 0 || i % start == 0)) {
                visited[i] = 1;
                help(N, start + 1, visited, result);
                visited[i] = 0;
            }
        }
    }

}
