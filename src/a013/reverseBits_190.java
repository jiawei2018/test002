package a013;

/**
 * 190.
 * Reverse Bits
 * Difficulty
 * Easy

 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Example:
 *
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
 *              return 964176192 represented in binary as 00111001011110000010100101000000.
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class reverseBits_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //解题思路
        //
        //设这个数为k，用一个初值为0的数r保存反转后的结果，
        // 用1对k进行求与，其结果与r进行相加，再对k向右进行一位移位，
        // 对r向左进行一位移位。值到k的最后一位处理完。
        int res = 0;
        for(int i = 0; i < 32; i++){
            res += n & 1;
             n>>>=1;
             if(i < 31){
                 res<<=1;
             }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = 43261596;
        reverseBits_190 t = new reverseBits_190();

        System.out.println(t.reverseBits(i));
    }
}
