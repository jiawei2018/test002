package a007;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code,
 * 7print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 *
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 *              A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 *              Therefore, for n = 0 the gray code sequence is [0].
 */
public class grayCode_089 {
//本题比较'不'重要,因为没什么代表性,
    //真正的考点在于recursion
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        //网上最常见的答案,没什么意义
        for(int i = 0; i < 1<<n; i++){
            res.add(i^i>>1);
        }

        return res;
    }
}


/**本题中正的考点在于下面
 *  public List<Integer> grayCode(int n) {
 *         if (n == 0) {
 *             List<Integer> list = new ArrayList<Integer>();
 *             list.add(0);
 *             return list;
 *         }
 *         if (n == 1) {
 *             List<Integer> list = new ArrayList<Integer>();
 *             list.add(0);
 *             list.add(1);
 *             return list;
 *         }
 *         List<Integer> grayM = grayCode(n - 1);
 *         List<Integer> list = new ArrayList<Integer>();
 *         for (int i = 0; i < Math.pow(2,n); i++) {
 *             if (i < Math.pow(2, n-1)) { //前面一半的数字不变
 *                 list.add(grayM.get(i));
 *             } else { //后面一半的数字反向排列，再在前面添加一个‘1’
 *                 int res =  grayM.get( (int)Math.pow(2, n) - i - 1 ) + (int)Math.pow(2, n - 1);
 *                 list.add(res);
 *             }
 *         }
 *         return list;
 *     }
 */


/**
 public List<Integer> grayCode(int n) {
     List<Integer> result = new LinkedList<>();
         if(n==0){
             result.add(0);
          return result;
         }
         if(n==1){
             result.add(0);
             result.add(1);
             return result;
         }
        int[] res=produce(n);
         for(int i=0;i<res.length;i++){
            result.add(res[i]);
         }
             return result;
         }

  public int[] produce(int n) {
     int[] strArr=new int[(int) Math.pow(2, n)];
     if(n==1){
         strArr[0]=0;
         strArr[1]=1;
         return strArr;
     }
     int[] lastStrings=produce(n-1);     //当前n的格雷码 从 n-1的格雷码中产生
     for(int i=0;i<lastStrings.length;i++){
         strArr[i]=lastStrings[i];
         strArr[strArr.length-1-i]=(1<<(n-1))+lastStrings[i];
     }
      return strArr;
 }
 */