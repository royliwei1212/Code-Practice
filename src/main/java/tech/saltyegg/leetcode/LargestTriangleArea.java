package tech.saltyegg.leetcode;

public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        if (points == null || points.length < 3) return 0;

        double result = 0;
        for (int i = 0; i < points.length - 2; i++) {
            int xa = points[i][0];
            int ya = points[i][1];
            for (int j = i + 1; j < points.length - 1; j++) {
                int xb = points[j][0];
                int yb = points[j][1];
                for (int k = j + 1; k < points.length; k++) {
                    int xc = points[k][0];
                    int yc = points[k][1];
                    double area = Math.abs(xa * yb + xb * yc + xc * ya - xa * yc - xb * ya - xc * yb) * 0.5;
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }


}
