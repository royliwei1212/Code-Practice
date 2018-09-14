package tech.saltyegg.leetcode;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int a = n >> 1;
        int b = a ^ n;
        if (b == 0) return true;
        while (b > 0) {
            int x = b & 1;
            if (x == 0) return false;
            b = b >> 1;
        }
        return true;
    }
}
