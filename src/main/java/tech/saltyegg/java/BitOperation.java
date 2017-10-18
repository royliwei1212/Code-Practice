package tech.saltyegg.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hzhou
 * @since 10/18/17
 */
public class BitOperation {

    public int updateBits(int m, int n, int i, int j) {
        return ((~((((-1) << (31 - j)) >>> (31 - j + i)) << i)) & n) | (m << i);
    }

    public int aplusb(int a, int b) {
        // 主要利用异或运算来完成
        // 异或运算有一个别名叫做：不进位加法
        // 那么a ^ b就是a和b相加之后，该进位的地方不进位的结果
        // 然后下面考虑哪些地方要进位，自然是a和b里都是1的地方
        // a & b就是a和b里都是1的那些位置，a & b << 1 就是进位
        // 之后的结果。所以：a + b = (a ^ b) + (a & b << 1)
        // 令a' = a ^ b, b' = (a & b) << 1
        // 可以知道，这个过程是在模拟加法的运算过程，进位不可能
        // 一直持续，所以b最终会变为0。因此重复做上述操作就可以
        // 求得a + b的值。
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }

    public boolean checkPowerOf2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public int bitSwapRequired(int a, int b) {
        return countOnes(a ^ b);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        // 1 << n  = 2^n
        // each subset equals to an binary integer between 0 .. 2^n-1
        // 0 -> 000 ->[]
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ...
        // 7 -> 111 -> [1,2,3]

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }

    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return -1;
        int result = 0;
        for (int a : A) {
            result ^= a;
        }
        return result;
    }

    public int singleNumber(int[] A, int n) {
        int one = 0, two = 0, i, j, k;
        for (i = 0; i < n; i++) {
            two = two | (one & A[i]);
            one = one ^ A[i];

            int three = two & one;
            two = two ^ three;
            one = one ^ three;
        }
        return one | two;
    }

    public int[] singleNumbers(int[] nums) {
        //用于记录，区分"两个"数组
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        //去最后一位1
        //先介绍一下原码,反码和补码
        //原码,就是其二进制表示（注意有一位符号位）
        //反码,正数的反码就是原码，负数的反码是符号位不变，其余位取反
        //补码,正数的补码就是原码，负数的补码是反码+1
        //在机器中都是采用补码形式存
        //diff & (-diff) 就是取diff的最后一位1的位置
        diff &= -diff;

        int[] result = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
