package a010;

/**
 * 137. Single Number II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a non-empty array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class singleNumber_II_137 {
    public static void main(String[] args) {
        int[] i = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
        singleNumber_II_137 t = new singleNumber_II_137();
        System.out.println(t.singleNumber(i));
    }
    public int singleNumber(int[] A) {
        int[] bits = new int[32];
        int res = 0;
        for(int i=0;i<32;i++) {
            for(int j=0;j<A.length;j++) {
                bits[i] += (A[j]>>i) & 1;
            }
            res = res | ((bits[i]%3) << i);//按 位 或
        }
        return res;
    }


    public int singleNumber1(int[] nums) {
        int[] arr = new int[32];
        int res = 0;
        for(int i = 0, right = 0; i < 32 ; i ++, right ++)
        {
            //给出3*n + 1 个的数字，除其中一个数字之外其他每个数字均出现三次，找到这个数字。
            //
            //思路：
            //java中int是32位的，所以我们利用一个32的数组，分别记录每一位1的情况，
            // 如果出现三次就清0，最后留下来的就是那个只出现1次的数字在那一位上的情况，然后进行移位复原
            for(int j = 0; j < nums.length; j ++ )
            {
                arr[i] += nums[j] >> right & 1;
                //右移 i 位, 在 与 1, 就 可以 判断 这位 是 1 还是 0

            }
            arr[i] %= 3;
        }
        for(int i = 0, left = 0; i < 32; i ++, left ++ )
        {
            res += arr[i] << left;
        }

        return res;

    }
}
