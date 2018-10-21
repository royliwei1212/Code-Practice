package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/11/17
 */
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.isEmpty()) return "";
        S = S.toUpperCase().replace("-", "");
        if (S.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int len = S.length();
        int start = 0;
        while (len > 0) {
            int l = len % K;
            if (l == 0) l = K;
            sb.append("-").append(S, start, start + l);
            start += l;
            len -= l;
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }

}
