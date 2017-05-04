package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2015/8/16.
 * Email: i@hzhou.me
 */
public class AddDigits {
    public int addDigits(int num) {
        while (num > 9) {
            num = getInt(num);
        }
        return num;
    }

    private int getInt(int num) {
        int result = 0;
        while (num >= 10) {
            result += num % 10;
            num /= 10;
        }
        result += num;
        return result;
    }
}
