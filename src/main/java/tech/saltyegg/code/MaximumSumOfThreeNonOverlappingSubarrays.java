package tech.saltyegg.code;

import org.junit.Test;

public class MaximumSumOfThreeNonOverlappingSubarrays {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Write your code here
        int n = nums.length, maxsum = 0;
        int[] sum = new int[n + 1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
//        print("S", sum);
        for (int i = k, tot = sum[k] - sum[0]; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > tot) {
                posLeft[i] = i + 1 - k;
                tot = sum[i + 1] - sum[i + 1 - k];
            } else {
                posLeft[i] = posLeft[i - 1];
            }
        }
        print("L", posLeft);
        posRight[n - k] = n - k;
        for (int i = n - k - 1, tot = sum[n] - sum[n - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i + k] - sum[i];
            } else {
                posRight[i] = posRight[i + 1];
            }
        }
        print("R", posRight);
        for (int i = k; i <= n - 2 * k; i++) {
            int l = posLeft[i - 1], r = posRight[i + k];
            int tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (tot > maxsum) {
                maxsum = tot;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }


    static void print(String label, int[] arr) {
        System.out.print(label + ": ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        int[] input = new int[]{1, 1, 1, 4, 1, 2, 6, 7, 5, 1,3,2};
        print("I", input);
        print("#", maxSumOfThreeSubarrays(input, 3));
    }
}
