package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2015/6/7.
 * Email: i@hzhou.me
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int all = (C - A) * (D - B) + (G - E) * (H - F);
        int lbx = Math.max(A, E);
        int lby = Math.max(B, F);
        int rtx = Math.min(C, G);
        int rty = Math.min(D, H);

        int width = rtx - lbx;
        int height = rty - lby;

        int result = 0;
        if (width > 0 && height > 0) {
            result = width * height;
        }
        return all - result;
    }
}
