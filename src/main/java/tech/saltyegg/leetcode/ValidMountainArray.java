package tech.saltyegg.leetcode;

public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;

        int peek = 0;
        while (peek + 1 < A.length && A[peek] < A[peek + 1]) peek++;
        if (peek == 0 || peek == A.length - 1) return false;
        while (peek + 1 < A.length && A[peek] > A[peek + 1]) peek++;
        return peek == A.length - 1;
    }
}
