package tech.saltyegg.leetcode;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) return new int[0][0];
        int len = A[0].length % 2 == 0 ? A[0].length / 2 : A[0].length / 2 + 1;

        for (int[] arr : A) {
            for (int s = 0; s < len; s++) {
                int e = arr.length - 1 - s;
                if (arr[s] != arr[e]) continue;
                int x = arr[s];
                arr[s] = x ^ 1;
                arr[e] = x ^ 1;
            }
        }

        return A;
    }
}
