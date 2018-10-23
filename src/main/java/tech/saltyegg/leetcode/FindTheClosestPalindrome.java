package tech.saltyegg.leetcode;

public class FindTheClosestPalindrome {

    public String nearestPalindromic(String n) {
        if (n == null || n.isEmpty()) return "";
        if (n.length() == 1) if (n.equals("0")) return "1"; else return String.valueOf(n.charAt(0) - '1');
        if (n.equals("11") || n.equals("10")) return "9";

        char[] arr = n.toCharArray();
        for (int i = 0, j = n.length() - 1; i < j; i++, j--) arr[j] = arr[i];

        String current = String.valueOf(arr);
        String next = helper(current, true);
        String prev = helper(current, false);

        long num = Long.parseLong(n);
        long crtVal = Long.parseLong(current);
        long nextVal = Long.parseLong(next);
        long prevVal = Long.parseLong(prev);
        long dn = nextVal - num;
        long dp = num - prevVal;
        long dc = Math.abs(crtVal - num);
        if (num == crtVal) {
            return dn < dp ? next : prev;
        }
        if (num > crtVal) {
            return dc <= dn ? current : next;
        } else {
            return dc >= dp ? prev : current;
        }

    }

    private String helper(String s, boolean isBig) {
        int l = s.length() / 2;
        int r = s.length() - l;
        int step = isBig ? 1 : -1;
        long num = Long.parseLong(s.substring(0, r)) + step;
        String numStr = String.valueOf(num);

        StringBuilder sbl = new StringBuilder(numStr);
        StringBuilder sbr = new StringBuilder(numStr).reverse();
        if (numStr.length() < l) sbr.append("9");
        return sbl.append(sbr.substring(sbr.length() - l)).toString();
    }
}
