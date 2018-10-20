package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.junit.Test;

public class IPToCIDR {

    public List<String> ipToCIDR(String ip, int n) {
        List<String> result = new ArrayList<>();
        long num = toLong(ip);
        while (n > 0) {
            int zero = Long.numberOfTrailingZeros(num);
            while ((1L << zero) > n) zero--;
            result.add(toString(num) + "/" + (32 - zero));
            n -= 1L << zero;
            num += 1L << zero;
        }

        return result;
    }

    private long toLong(String ip) {
        long result = 0;
        for (String s : ip.split("\\.")) {
            result = (result << 8) + Integer.parseInt(s);
        }
        return result;
    }

    private String toString(long num) {
        StringJoiner sj = new StringJoiner(".");
        for (int x : new int[]{24, 16, 8, 0}) {
            sj.add(String.valueOf((num >> x) % 256));
        }
        return sj.toString();
    }

    @Test
    public void test() {
        System.out.println(ipToCIDR("255.0.0.7", 10));
    }
}
