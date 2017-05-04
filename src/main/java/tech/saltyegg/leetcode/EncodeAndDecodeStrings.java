package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hzhou on 2016/5/11.
 * Email: i@hzhou.me
 */
public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null) return null;
        if (strs.size() == 0) return "";

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s == null ? "" : s);
        }
        sb.append('-');
        for (String s : strs) {
            sb.append(',').append(s == null ? -1 : s.length());
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null) return null;
        if (s.isEmpty()) return Collections.emptyList();

        int index = s.lastIndexOf('-');
        String[] counts = s.substring(index + 2).split(",");

        List<String> result = new ArrayList<>();
        int crt = 0;
        for (String c : counts) {
            int length = Integer.valueOf(c);
            if (length == -1) {
                result.add(null);
            } else {
                result.add(s.substring(crt, crt + length));
                crt += length;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings ed = new EncodeAndDecodeStrings();
        List<String> list = new ArrayList<>();
        list.add("0k<*");
        list.add("G");
        String s = ed.encode(list);
        List<String> result = ed.decode(s);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));