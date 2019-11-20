package a005;

/**
 * 66. Plus One
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class plusOne {

    public int[] plusOne(int[] digits) {
        // 我的方法太笨了.......
        if(digits.length == 0) return digits;
        int[] res = new int[digits.length];
        int curr = 1;

        for(int i = digits.length - 1; i >= 0; i--){//针对此题,应该只考虑 9的情况.
                 res[i] = (digits[i] + curr) % 10;
                 curr = (digits[i] + curr) / 10;
        }

        int[] tmp = new int[digits.length + 1] ;

        if(curr > 0) {
            tmp[0] = 1;
        }
        return curr > 0 ? tmp:res;
    }

        // answer
    private int[] plusOneA(int[] digits) {
        int n = digits.length;
        //一般情况
        for (int i = n - 1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            } else {//equal to 9
                digits[i] = 0;
            }
        }
        //下面部分用于处理数组中的元素全是9的情况，如9999--》10000
        //初始化数组时，数组中元素均初始化为0，故只需要将数组中第一个元素置位1即可。
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

}
