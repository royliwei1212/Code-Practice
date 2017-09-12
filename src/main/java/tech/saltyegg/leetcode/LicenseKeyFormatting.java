package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/11/17
 */
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.isEmpty()) {
            return "";
        }

        String str = S.replaceAll("-", "").toUpperCase();
        if (str.length() <= K) {
            return str;
        }

        int batch = str.length() / K;
        int offset = str.length() - batch * K;
        String prefix = str.substring(0, offset);
        String suffix = str.substring(offset).replaceAll("([A-Za-z0-9]{" + K + "})", "-$1");
        return prefix.isEmpty() ? suffix.substring(1) : prefix + suffix;
    }

}
