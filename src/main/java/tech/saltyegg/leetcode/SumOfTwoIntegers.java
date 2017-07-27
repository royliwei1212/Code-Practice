package tech.saltyegg.leetcode;

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        if (b == 0) return a;
        int x = a ^ b;
        int y = (a & b) << 1;
        return getSum(x, y);
    }

}
