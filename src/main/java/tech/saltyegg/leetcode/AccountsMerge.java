package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        if (accounts == null || accounts.isEmpty()) return result;
        UF uf = new UF(accounts.size());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                if (map.containsKey(acc.get(j))) {
                    uf.union(i, map.get(acc.get(j)));
                }
                map.put(acc.get(j), i);
            }
        }

        boolean[] visited = new boolean[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            if (visited[i]) continue;
            Set<String> set = new TreeSet<>();
            for (int j = i; j < accounts.size(); j++) {
                if (!uf.find(i, j)) continue;
                visited[j] = true;
                for (int k = 1; k < accounts.get(j).size(); k++) set.add(accounts.get(j).get(k));
            }
            if (set.isEmpty()) continue;
            List<String> list = new ArrayList<>();
            list.add(accounts.get(i).get(0));
            list.addAll(set);
            result.add(list);
        }

        return result;
    }

    static class UF {
        int[] id;

        UF(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++) id[i] = i;
        }

        int root(int p) {
            while (id[p] != p) p = id[p];
            return p;
        }

        boolean find(int p, int q) {
            return root(p) == root(q);
        }

        void union(int p, int q) {
            int rp = root(p);
            int rq = root(q);
            for (int i = 0; i < id.length; i++) {
                if (id[i] == rp) id[i] = rq;
            }
        }
    }

    @Test
    public void test() {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        input.add(Arrays.asList("John", "johnnybravo@mail.com"));
        input.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        input.add(Arrays.asList("Mary", "mary@mail.com"));

        accountsMerge(input);
    }
}
