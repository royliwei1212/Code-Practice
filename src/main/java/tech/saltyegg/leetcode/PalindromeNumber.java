package tech.saltyegg.leetcode;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) return true;
        if (x < 0 || x % 10 == 0) return false;


        int right = 0;
        while (right < x) {
            right = 10 * right + (x % 10);
            x /= 10;
        }
        return right == x || x == right / 10;
    }

}