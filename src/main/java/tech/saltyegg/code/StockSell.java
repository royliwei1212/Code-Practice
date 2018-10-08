package tech.saltyegg.code;

import java.util.Arrays;

public class StockSell {

    // 1次交易
    public int maxProfit1(int[] prices) {
        int buy = Integer.MIN_VALUE, sell = 0;
        for (int i : prices) {
            buy = Math.max(buy, -i);
            sell = Math.max(sell, buy + i);
        }
        return sell;
    }

    // 无限次交易
    public int maxProfit2(int[] prices) {
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            sell += Math.max(0, prices[i] - prices[i - 1]);
        }
        return sell;
    }

    // 2次交易
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int i : prices) {
            buy1 = Math.max(buy1, -i);
            sell1 = Math.max(sell1, buy1 + i);
            buy2 = Math.max(buy2, sell1 - i);
            sell2 = Math.max(sell2, buy2 + i);
        }
        return sell2;
    }

    // k次交易
    public int maxProfit4(int k, int[] prices) {
        int len = prices.length;
        if (len < 2 || k == 0) return 0;
        int[] buys = new int[k + 1];
        int[] sells = new int[k + 1];
        Arrays.fill(buys, Integer.MIN_VALUE);
        for (int i : prices) {
            for (int j = 1; j <= k; j++) {
                buys[j] = Math.max(buys[j], sells[j - 1] - i);
                sells[j] = Math.max(sells[j], buys[j] + i);
            }
        }
        return sells[k];
    }

    // 冷却时间
    public int maxProfit5(int[] prices) {
        int len = prices.length;
        int[] buys = new int[len];
        int[] sells = new int[len];
        buys[0] = -prices[0];
        buys[1] = prices[0] > prices[1] ? -prices[1] : -prices[0];
        sells[1] = prices[0] > prices[1] ? 0 : prices[1] - prices[0];
        for (int i = 2; i < len; i++) {
            buys[i] = Math.max(buys[i - 1], sells[i - 2] - prices[i]);
            sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i]);
        }
        return sells[len - 1];
    }

    //交易费
    public int maxProfit6(int[] prices, int fee) {
        int sell = 0, buy = Integer.MIN_VALUE;
        for (int i : prices) {
            buy = Math.max(buy, sell - i);
            sell = Math.max(sell, buy + i - fee);
        }
        return sell;
    }

}
