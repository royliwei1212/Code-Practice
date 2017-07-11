package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 7/11/17
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num / i; i++) {
            if (num == i * i) {
                return true;
            }
        }
        return false;
    }

}
