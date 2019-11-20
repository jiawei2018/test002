package a013;

/**
 * 201.
 * Bitwise AND of Numbers Range
 * Difficulty
 * Medium

 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 */
public class bitwiseAND_ofAllNumbersRange_201 {
    public static void main(String[] args) {
        System.out.println(5&6&7);//is 4
    }
    public int rangeBitwiseAnd(int m, int n) {
//     * 此题还有另一种解法，不需要用mask，直接平移m和n，每次向右移一位，
//     * 直到m和n相等，记录下所有平移的次数i，然后再把m左移i位即为最终结果，代码如下：
        int pos = 0;

        for(pos = 0; pos < 32 && m != n; pos++){
            m >>= 1;
            n >>= 1;
        }

        return n << pos;
    }

    /**
     * 此题还有另一种解法，不需要用mask，直接平移m和n，每次向右移一位，
     * 直到m和n相等，记录下所有平移的次数i，然后再把m左移i位即为最终结果，代码如下：
     *
     * 解法二：
     *     int rangeBitwiseAnd(int m, int n) {
     *         //the slowest
     *         int i = 0;
     *         while (m != n) {
     *             m >>= 1;
     *             n >>= 1;
     *             ++i;
     *         }
     *         return (m << i);
     *     }
     * 复制代码
     * 下面这种方法有点叼，就一行搞定了，通过递归来做的，如果n大于m，那么就对m和n分别除以2，
     * 并且调用递归函数，对结果再乘以2，一定要乘回来，不然就不对了，
     * 就举一个最简单的例子，m = 10, n = 11，注意这里是二进制表示的，然后各自除以2，
     * 都变成了1，调用递归返回1，这时候要乘以2，才能变回10，参见代码如下：
     *
     * 解法三：
     * class Solution {
     * public:
     *     int rangeBitwiseAnd(int m, int n) {
     *     //the second fast
     *         return (n > m) ? (rangeBitwiseAnd(m / 2, n / 2) << 1) : m;
     *     }
     *
     *
     *下面这种方法也不错，也很简单，如果m小于n就进行循环，n与上n-1，
     * 那么为什么要这样与呢，举个简单的例子呗，110与上(110-1)，得到100，
     * 这不就相当于去掉最低位的1么，n就这样每次去掉最低位的1，
     * 如果小于等于m了，返回此时的n即可，参见代码如下：
     * 解法四：
     *
     * 复制代码
     * class Solution {
     * public:
     *     int rangeBitwiseAnd(int m, int n) {
     *     //the fastest,why???
     *         while (m < n) {
     *           n &= (n - 1);
     *         }
     *         return n;
     *     }
     */
}
