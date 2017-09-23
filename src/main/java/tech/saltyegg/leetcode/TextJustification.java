package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        if (maxWidth == 0) return Collections.singletonList("");
        int start = 0;
        int length = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (length + s.length() <= maxWidth) {
                length += s.length() + 1;
            } else {
                result.add(helper(words, start, i - 1, length - 1, maxWidth));
                length = s.length() + 1;
                start = i;
            }
        }
        result.add(lastLine(words, start, maxWidth));
        return result;
    }

    private String lastLine(String[] words, int start, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        while (start < words.length) {
            sb.append(words[start]);
            if (sb.length() < maxWidth) sb.append(" ");
            start++;
        }
        appendSpace(sb, maxWidth - sb.length());
        return sb.toString();
    }

    private String helper(String[] words, int start, int end, int length, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (end == start) {
            sb.append(words[start]);
            appendSpace(sb, maxWidth - words[start].length());
            return sb.toString();
        }

        int totalPadding = maxWidth - (length - end + start);
        int interval = end - start;
        int step = totalPadding / interval + (totalPadding % interval > 0 ? 1 : 0);
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            appendSpace(sb, Math.min(step, totalPadding));
            totalPadding -= step;
            interval--;
            if (interval > 0) step = totalPadding / interval + (totalPadding % interval > 0 ? 1 : 0);
        }
        return sb.toString();
    }

    private void appendSpace(StringBuilder sb, int count) {
        if (count <= 0) return;
        while (count > 0) {
            sb.append(" ");
            count--;
        }
    }
}