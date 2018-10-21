package tech.saltyegg.leetcode;

public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || k < 0 || flowers.length < k + 2) return -1;

        int[] day = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) day[flowers[i] - 1] = i + 1;

        int l = 0, r = k + 1, result = Integer.MAX_VALUE;

        for (int i = 0; r < day.length; i++) {
            if (day[i] < day[l] || day[i] <= day[r]) {
                if (i == r) {
                    result = Math.min(result, Math.max(day[l], day[r]));
                }

                l = i;
                r = k + i + 1;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
