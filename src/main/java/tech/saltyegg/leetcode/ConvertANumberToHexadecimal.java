package tech.saltyegg.leetcode;

public class ConvertANumberToHexadecimal {

    public String toHex(int num) {
        String result = "";
        for (int i = 0; num != 0 && i < 8; i++) {
            int x = num & 0xf;
            if (x >= 10) {
                char a = (char) ('a' + x - 10);
                result = a + result;
            } else {
                result = x + result;
            }
            num = num >> 4;
        }
        return result.isEmpty() ? "0" : result;
    }

}
