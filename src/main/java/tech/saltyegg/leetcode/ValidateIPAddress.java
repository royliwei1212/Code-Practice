package tech.saltyegg.leetcode;

public class ValidateIPAddress {

    public String validIPAddress(String IP) {
        String NEITHER = "Neither";
        String IPV4 = "IPv4";
        String IPV6 = "IPv6";
        if (IP == null || IP.trim().isEmpty()) {
            return NEITHER;
        }
        IP = IP.toLowerCase();
        if (IP.contains(".")) {
            String[] split = IP.split("\\.", -1);
            if (split.length == 4) {
                for (String s : split) {
                    if (s.length() > 3 || s.isEmpty()) return NEITHER;
                    try {
                        int x = Integer.parseInt(s);
                        if (!(x >= 0 && x < 256 && String.valueOf(x).equals(s))) {
                            return NEITHER;
                        }
                    } catch (Exception e) {
                        return NEITHER;
                    }
                }
                return IPV4;
            }

        } else if (IP.contains(":")) {
            String[] split = IP.split(":", -1);
            if (split.length == 8) {
                for (String s : split) {
                    if (s.length() > 4 || s.isEmpty() || !s.matches("[0-9a-f]+")) {
                        return NEITHER;
                    }
                }
                return IPV6;
            }
        }
        return NEITHER;
    }
}
