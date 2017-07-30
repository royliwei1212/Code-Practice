package tech.saltyegg.leetcode;

public class ArrangingCoins {

    public int arrangeCoins(int n) {
        return ((int) Math.sqrt(1 + 8L * n) - 1) / 2;
    }
}
