package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/2/17
 */
public class StudentAttendanceRecordII {

    // https://discuss.leetcode.com/topic/86696/share-my-o-n-c-dp-solution-with-thinking-process-and-explanation/2
    public int checkRecord(int n) {

        if (n == 1) return 3;
        if (n == 2) return 8;

        final int M = 1000000007;

        int[] P = new int[n];
        int[] A = new int[n];
        int[] L = new int[n];

        P[0] = A[0] = L[0] = 1;
        L[1] = 3;
        A[1] = 2;
        A[2] = 4;

        for (int i = 1; i < n; i++) {

            P[i - 1] %= M;
            A[i - 1] %= M;
            L[i - 1] %= M;

            P[i] = ((P[i - 1] + A[i - 1]) % M + L[i - 1]) % M;
            if (i > 1) {
                L[i] = ((P[i - 1] + A[i - 1]) % M + (A[i - 2] + P[i - 2]) % M) % M;
            }

            if (i > 2) {
                A[i] = ((A[i - 1] + A[i - 2]) % M + A[i - 3]) % M;
            }
        }

        return ((A[n - 1] + P[n - 1]) % M + L[n - 1]) % M;

    }
}
