package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 8/27/17
 */
public class TwoKeysKeyboard {

    public int minSteps(int n) {
        int result = n;
        if (n == 1) return 0;
        for (int i = n - 1; i > 1; i--) {
            if (n % i == 0) {
                result = Math.min(result, minSteps(i) + n / i);
            }
        }
        return result;
    }

}
