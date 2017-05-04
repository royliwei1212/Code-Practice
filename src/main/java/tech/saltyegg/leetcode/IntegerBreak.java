package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/5/21.
 * Email: i@hzhou.me
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) return 1;
        if (n == 3) return 2;

        int x = n / 3;
        int y = n % 3;
        switch (y) {
            case 0:
                return (int) Math.pow(3, x);
            case 1:
                return (int) Math.pow(3, x - 1) * 4;
            case 2:
                return (int) Math.pow(3, x) * 2;
        }

        return 0;
    }

}
