package tech.saltyegg.leetcode;

public class UTF8Validation {

    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) return true;
        int mask = 0b1000_0000;
        int prefixMask = 0b1100_0000;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < mask) continue;
            int cnt = 0;
            int m = mask;
            while ((data[i] & m) != 0) {
                m >>= 1;
                cnt++;
            }
            if (cnt < 2 || cnt > 4 || i + cnt > data.length) return false;

            for (int k = 1; k < cnt; k++) {
                if ((data[++i] & prefixMask) != mask) return false;
            }

        }
        return true;
    }
}
