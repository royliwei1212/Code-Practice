package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/4/17.
 * Email: i@hzhou.me
 * <p>
 * Given an integer, write a function to determine if it is a power of three.
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }

        if (n < 3) {
            return false;
        }

        while (n / 3 > 0) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
            if(n == 1){
                return true;
            }
        }

        return false;
    }
}
