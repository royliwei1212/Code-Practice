package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/5/21.
 * Email: i@hzhou.me
 */
public class CountingBits {

    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int[] result = new int[num + 1];

        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= num; i++) {
            int x = (int) (Math.log(i) / Math.log(2));
            int mod = i - (1 << x);
            int res = 1;
            while (mod >= 2) {
                x = (int) (Math.log(mod) / Math.log(2));
                mod = mod - (1 << x);
                res++;
            }
            if (mod == 1) {
                res++;
            }
            result[i] = res;
        }

        return result;
    }


    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        cb.countBits(8);
    }
}
