package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.GuessGame;

public class GuessNumberHigherOrLower extends GuessGame {

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int m = l + (-l + r) / 2;
            int res = guess(m);
            if (res == 0) {
                return m;
            }

            if (res < 0) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

}
