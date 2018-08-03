package tech.saltyegg.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class LogProcessor {

    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        List<String> result = new ArrayList<>();
        List<String> numberLines = new ArrayList<>();

        Comparator<String> keyComparator = (o1, o2) -> {
            if (Objects.equals(o1, o2)) {
                return 0;
            }
            int length = Math.min(o1.length(), o2.length());
            for (int i = 0; i < length; i++) {
                char c1 = o1.charAt(i);
                char c2 = o2.charAt(i);
                if (c1 == c2) {
                    continue;
                }
                if (isNumber(c1) && isLetter(c2)) {
                    return -1;
                }

                if (isLetter(c1) && isNumber(c2)) {
                    return 1;
                }
                return c1 - c2;
            }
            return o1.length() - o2.length();
        };

        Comparator<String> valueComparator = (o1, o2) -> {
            if (Objects.equals(o1, o2)) {
                return 0;
            }
            char c1 = o1.charAt(0);
            char c2 = o2.charAt(0);
            if (isLetter(c1) && isNumber(c2) || isNumber(c1) && isNumber(c2)) {
                return -1;
            }
            if (isNumber(c1) && isLetter(c2)) {
                return 1;
            }

            String s1 = o1.replaceAll(" ", "");
            String s2 = o2.replaceAll(" ", "");

            return s1.compareTo(s2);
        };

        Comparator<String> lineComparator = (o1, o2) -> {
            String[] l1 = parseLine(o1);
            String[] l2 = parseLine(o2);
            char vc1 = l1[1].charAt(0);
            char vc2 = l2[1].charAt(0);
            if (isNumber(vc1) && isNumber(vc2)) {
                return -1;
            }

            int vc = valueComparator.compare(l1[1], l2[1]);
            if (vc != 0) {
                return vc;
            }
            return keyComparator.compare(l1[0], l2[0]);
        };

        PriorityQueue<String> queue = new PriorityQueue<>(lineComparator);
        for (int i = 0; i < logFileSize && i < logLines.size(); i++) {
            String s = logLines.get(i);
            String[] line = parseLine(s);
            if (isNumber(line[1].charAt(0))) {
                // priority queue是基于heap的，不能保证2个"无序"的instance先进去的就一定先出来
                numberLines.add(s);
            } else {
                queue.add(logLines.get(i));
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        result.addAll(numberLines);

        return result;
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private String[] parseLine(String s) {
        s = s.trim();
        int index = s.indexOf(' ');
        String key = s.substring(0, index);
        String val = s.substring(index + 1);
        return new String[]{key.trim(), val.trim()};
    }

    public static void main(String[] args) {
        LogProcessor lp = new LogProcessor();
        List<String> result = lp.reorderLines(7, Arrays.asList(
                "12x ew sw vf",
                "1x 12 23 4",
                "1x ew sw vf",
                "x1 ew sw vf",
                "x1 e sw vf",
                "x1 12 4 7787878",
                "x1 ewa sw vf"
        ));
        for (String s : result) {
            System.out.println(s);
        }

        //        x1 e sw vf
        //        x1 ewa sw vf
        //        12x ew sw vf
        //        1x ew sw vf
        //        x1 ew sw vf
        //        1x 12 23 4
        //        x1 12 4 7787878
    }
}
