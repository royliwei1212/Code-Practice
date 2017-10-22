package tech.saltyegg.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hzhou
 * @since 9/24/17
 */
public class SolutionIter implements Iterable<Integer> {

    private List<Integer> iter;
    private String REGX = "[+-]?[0-9]{1,10}";

    public SolutionIter(Reader inp) {
        iter = new LinkedList<>();
        if (inp == null) return;
        try (BufferedReader br = new BufferedReader(inp)) {
            for (String line; (line = br.readLine()) != null; ) {
                // process the line
                line = line.trim();
                if(line.isEmpty()) continue;
                if (!line.matches(REGX)) {
                    continue;
                }
                long value = Long.parseLong(line);
                if (isInRange(value)) {
                    iter.add((int) value);
                }
            }

        } catch (IOException e) {
            // or anything else we can do, for now, just print the stack trace
            e.printStackTrace();
        }
    }

    public Iterator<Integer> iterator() {
        return iter.iterator();
    }

    private boolean isInRange(long x) {
        return x >= -1_000_000_000 && x <= 1_000_000_000;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}