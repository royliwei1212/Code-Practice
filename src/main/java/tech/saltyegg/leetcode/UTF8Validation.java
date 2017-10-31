package tech.saltyegg.leetcode;

public class UTF8Validation {

    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) return false;
        int count = 0;
        int mask = 0b1100_0000;
        int prefix = 0b1000_0000 & mask;

        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0b1000_0000) {
                continue;
            }
            count = getKey(data[i++]);
            if (!isValidKey(count)) return false;

            while (count > 0 && i < data.length) {
                if ((data[i] & mask) != prefix) return false;
                count--;
                i++;
            }
            if (i < data.length) i--;
        }
        return count == 0;
    }

    private int getKey(int x) {
        int mask = 0b1000_0000;

        int result = 0;
        while ((x & mask) != 0 && result <= 4) {
            result++;
            mask >>= 1;
        }
        return result > 4 || result == 1 ? -1 : Math.max(0, result - 1);
    }

    private boolean isValidKey(int key) {
        return key >= 0 && key <= 3;
    }
}
