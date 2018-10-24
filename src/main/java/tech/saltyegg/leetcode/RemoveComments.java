package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        if (source == null || source.length == 0) return result;
        StringBuilder sb = new StringBuilder();
        boolean ic = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (ic) {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        ic = false;
                        i++;
                    }
                } else {
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') break;
                    else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        ic = true;
                        i++;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }

            }
            if (!ic && sb.length() > 0) {
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        return result;
    }
}
