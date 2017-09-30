package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 4/23/15. codeashobby@gmail.com
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n = n - 1;
            int m = n % 26;
            sb.insert(0, (char) ('A' + m));
            n = n / 26;
        }
        return sb.toString();
    }
}
