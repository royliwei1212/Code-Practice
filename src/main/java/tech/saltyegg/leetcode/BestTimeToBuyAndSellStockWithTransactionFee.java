package tech.saltyegg.leetcode;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    //(1) If we are holding the stock at the end of day i, the max possible profit at the end of day i is recorded as: hold[i]
    //(2) If we are holding nothing at the end of day i, the max possible profit at the end of day i is recorded as: empty[i]

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;

        int[] hold = new int[prices.length];
        int[] empty = new int[prices.length];
        hold[0] = -prices[0];
        empty[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i - 1], empty[i - 1] - prices[i]);
            empty[i] = Math.max(empty[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return empty[prices.length - 1];
    }
}
