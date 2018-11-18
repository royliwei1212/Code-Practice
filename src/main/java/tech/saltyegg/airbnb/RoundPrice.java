package tech.saltyegg.airbnb;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class RoundPrice {

    public int[] roundUp(double[] arr) {
        double sum = 0;
        int sumInt = 0;
        Num[] list = new Num[arr.length];
        for (int i = 0; i < arr.length; i++) {
            double d = arr[i];
            int f = (int) d;
            int c = f;
            if (f < d) c++;
            sum += d;
            sumInt += f;
            list[i] = new Num(c, c == f ? Double.MAX_VALUE : c - d);
        }
        Arrays.sort(list, Comparator.comparingDouble(Num::getDiff));
        int num = (int) Math.round(sum);
        int diff = num - sumInt;

        int[] result = new int[arr.length];
        int i = 0;
        for (; i < diff; i++) {
            result[i] = list[i].num;
        }
        for (; i < arr.length; i++) {
            result[i] = list[i].diff.equals(Double.MAX_VALUE) ? list[i].num : list[i].num - 1;
        }
        return result;
    }

    static class Num {
        Integer num;
        Double diff;

        Num(int num, double diff) {
            this.num = num;
            this.diff = diff;
        }

        Double getDiff() {
            return diff;
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(roundUp(new double[]{1.2, 2.3, 3.4})));
        System.out.println(Arrays.toString(roundUp(new double[]{1.2, 2.5, 3.6, 4.0})));
    }
}
