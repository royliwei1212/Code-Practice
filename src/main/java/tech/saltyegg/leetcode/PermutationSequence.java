/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, We get the following sequence (ie, for n = 3):
 * <pre>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * </pre>
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 *
 * @author hzhou
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int t = 1;
        List<Integer> numbers = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            t = t * i;
            numbers.add(i);
        }
        t /= n;
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 1; i--) {
            int p = k / t;
            int np = numbers.get(p);
            sb.append(np);
            numbers.remove(p);
            k %= t;
            t /= i;
        }
        sb.append(numbers.get(0));
        return sb.toString();
    }

    @Test
    public void test() {
        String result = getPermutation(3, 5);
    }
}