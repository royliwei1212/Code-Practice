package tech.saltyegg.leetcode;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = 1;
        for (int i : flowerbed) {
            if (i == 0) {
                len++;
            } else {
                n -= (len - 1) / 2;
                len = 0;
            }
        }
        if (flowerbed[flowerbed.length-1] == 0) {
            len++;
            n -= (len - 1) / 2;
        }
        return n < 1;
    }

}
