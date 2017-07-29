package tech.saltyegg.leetcode;

public class ConstructTheRectangle {

    public int[] constructRectangle(int area) {
        if (area < 0) return new int[2];

        int x = (int) Math.sqrt(area);
        int[] result = new int[2];
        int a = 0;
        int b = 0;
        for (int i = x; i <= area; i++) {
            if (area % i == 0) {
                a = i;
                b = area / i;
                break;
            }
        }
        result[0] = Math.max(a, b);
        result[1] = Math.min(a, b);
        return result;
    }
}
