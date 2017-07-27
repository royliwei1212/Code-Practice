package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.GuessGame;

public class GuessNumberHigherOrLower extends GuessGame {

    public int guessNumber(int n) {
        return helper(1, n);
    }

    private int helper(int l, int r) {
        if (l == r) return l;

        int m = (l + r) / 2;
        int res = guess(m);
        if (res == 0) {
            return m;
        }

        if (res < 0) {
            return helper(l, m - 1);
        } else {
            return helper(m + 1, r);
        }
    }
}
