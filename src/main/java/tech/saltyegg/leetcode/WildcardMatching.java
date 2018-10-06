package tech.saltyegg.leetcode;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int sCrt = 0, pCrt = 0, sStar = -1, pStar = -1;
        while (sCrt < s.length()) {
            if (pCrt < p.length() && (s.charAt(sCrt) == p.charAt(pCrt) || p.charAt(pCrt) == '?')) {
                sCrt++;
                pCrt++;
            } else if (pCrt < p.length() && p.charAt(pCrt) == '*') {
                pStar = pCrt;
                pCrt++;
                sStar = sCrt;
            } else if (pStar > -1) {
                pCrt = pStar + 1;
                sStar++;
                sCrt = sStar;
            } else {
                return false;
            }
        }
        while (pCrt < p.length() && p.charAt(pCrt) == '*') {
            pCrt++;
        }
        return pCrt == p.length();
    }
}