package tech.saltyegg.leetcode;

public class PourWater {

    public int[] pourWater(int[] heights, int V, int K) {
        if (heights == null || heights.length == 0 || K >= heights.length || K < 0 || V <= 0) return heights;

        while (V-- > 0) {
            int t = K;
            for (int i = K - 1; i >= 0; i--) {
                while (i >= 0 && heights[i] == heights[t]) i--;
                if (i < 0 || heights[i] >= heights[t]) {
                    break;
                } else {
                    t = i;
                }
            }

            if (t < K) {
                heights[t] += 1;
                continue;
            }

            for (int i = K + 1; i < heights.length; i++) {
                while (i < heights.length && heights[i] == heights[t]) i++;
                if (i == heights.length || heights[i] >= heights[t]) {
                    break;
                } else {
                    t = i;
                }
            }
            heights[t] += 1;

        }
        return heights;

    }

}
