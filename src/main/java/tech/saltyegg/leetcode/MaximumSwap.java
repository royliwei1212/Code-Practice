package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/5/17
 */
public class MaximumSwap {

    public int maximumSwap(int num) {
        if (num < 10) return num;
        String numStr = num + "";
        int[] arr = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) arr[i] = numStr.charAt(i) - '0';
        int[] dp = new int[numStr.length()];
        dp[dp.length - 1] = num % 10;
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], arr[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == arr[i]) continue;
            for (int j = dp.length - 1; j >= 0; j--) {
                if (dp[j] != dp[i]) continue;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                break;
            }
            break;
        }
        int result = 0;
        for (int n : arr) {
            result = 10 * result + n;
        }
        return result;
    }

}
