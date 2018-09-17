package tech.saltyegg.leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PrefixAndSuffixSearch {

    private final TreeMap<String, Integer> preMap = new TreeMap<>();
    private final TreeMap<String, Integer> sufMap = new TreeMap<>();

    public PrefixAndSuffixSearch(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            preMap.put(w, i);
            sufMap.put(new StringBuilder(w).reverse().toString(), i);
        }
    }

    public int f(String prefix, String suffix) {
        TreeSet<Integer> preSet = new TreeSet<>(Comparator.reverseOrder());
        Set<Integer> sufSet = new HashSet<>();
        Map.Entry<String, Integer> entry = preMap.ceilingEntry(prefix);

        while (entry != null && entry.getKey().startsWith(prefix)) {
            preSet.add(entry.getValue());
            entry = preMap.higherEntry(entry.getKey());
        }

        String suffixx = new StringBuilder(suffix).reverse().toString();
        entry = sufMap.ceilingEntry(suffixx);
        while (entry != null && entry.getKey().startsWith(suffixx)) {
            sufSet.add(entry.getValue());
            entry = sufMap.higherEntry(entry.getKey());
        }

        for (int p : preSet) {
            if (sufSet.contains(p)) {
                return p;
            }
        }

        return -1;
    }

}
