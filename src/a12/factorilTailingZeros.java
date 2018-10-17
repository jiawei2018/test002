package a12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 172.
 * Factorial Trailing Zeroes
 * <p>
 * Submissions
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * <p>
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class factorilTailingZeros {
    public int trailingZeroes(int n) {
        int res = 0;
        int temp = 0;
        while (n > 0) {
            temp = n / 5;
            res += temp;
            n = temp;
        }
        return res;
    }
}
