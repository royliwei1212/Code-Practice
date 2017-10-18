package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 4/27/15. codeashobby@gmail.com
 */
public class UniqueBinarySearchTrees {
    //TODO
    public int numTrees(int n) {
        if (n < 0) {
            return 0;
        }
        int[] result = new int[n + 2];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i - 1 - j];
            }
        }
        return result[n];
    }
}
