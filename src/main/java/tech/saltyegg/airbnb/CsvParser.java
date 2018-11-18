package tech.saltyegg.airbnb;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CsvParser {

    public String parse(String s) {
        if (s == null || s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();
        boolean quoteMode = false;
        int n = s.length();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (quoteMode) {
                if (c == '"') {
                    if (i < n - 1 && s.charAt(i + 1) == '"') {
                        sb.append('"');
                        i++;
                    } else {
                        quoteMode = false;
                    }
                } else {
                    sb.append(c);
                }
            } else {
                if (c == '"') {
                    quoteMode = true;
                } else {
                    if (c == ',') {
                        result.add(sb.toString());
                        sb.setLength(0);
                    } else {
                        sb.append(c);
                    }
                }
            }
        }
        if (sb.length() > 0) result.add(sb.toString());
        return String.join("|", result);
    }

    @Test
    public void test() {
        assertEquals(parse("\"LA \"\"Alex\"\"\",Men,2,Miami,1 \"\"\"LA Alex\"\"\""),
                "LA \"Alex\"|Men|2|Miami|1 \"LA Alex\"");
    }
}
