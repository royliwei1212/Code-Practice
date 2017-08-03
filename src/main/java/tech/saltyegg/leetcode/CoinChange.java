package tech.saltyegg.leetcode;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length < 1) return -1;
        Arrays.sort(coins);
        if (amount == 0) return 0;
        if (coins[0] > amount) return -1;

        int[] dict = new int[amount + 1];
        for (int i = 0; i < dict.length; i++) {
            dict[i] = -1;
        }
        for (int i : coins) {
            if (i <= amount) {
                dict[i] = 1;
            }
        }
        for (int i = coins[0] + 1; i <= amount; i++) {
            int x = dict[i] != -1 ? Math.min(dict[i], findMin(coins, dict, i)) : findMin(coins, dict, i);
            dict[i] = x == Integer.MAX_VALUE ? -1 : x;
        }
        return dict[amount];
    }

    private int findMin(int[] coins, int[] dict, int index) {
        int result = Integer.MAX_VALUE;
        for (int i : coins) {
            if (index - i >= 0 && dict[index - i] > 0) {
                result = Math.min(result, dict[index - i] + 1);
            }
        }
        return result;
    }

}
