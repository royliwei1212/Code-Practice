package tech.saltyegg.leetcode;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeroCount = 1;
        for (int f : flowerbed) {
            if (f == 0) {
                zeroCount++;
            } else if (zeroCount > 0) {
                n -= (zeroCount - 1) / 2;
                if (n == 0) return true;
                zeroCount = 0;
            }
        }
        if (zeroCount > 0) {
            n -= (zeroCount) / 2;
        }
        return n <= 0;
    }

}
