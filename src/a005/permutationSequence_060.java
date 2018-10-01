package a005;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. Permutation Sequence
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class permutationSequence_060 {
    public String getPermutation(int n, int k) {
    //recursion ,,,  p it is ;
        //超时
        //热recursion  超时,要dp了......//想法错了,或者也可能么?
        if(n == 1) return "1";
        StringBuilder s1 = new StringBuilder();
        for(int i = 1; i <= n; i++){
            s1 =s1.append(i);
        }
        if(k == 1){
            return s1.toString();
        }

        char[] input = s1.toString().toCharArray();
        int len = input.length;
        boolean[] used = new boolean[len];
        StringBuilder res= new StringBuilder();
        List<String> ans = new ArrayList<>();
        recur(input, used, ans, res, k );
        return ans.get(k -1 );
    }
    private void recur(char[] input, boolean[] used, List<String> ans, StringBuilder res, int k){
        if(res.length() == input.length ){
             ans.add(res.toString());
             if(ans.size() == k) return;
              return;//res is answer
        }
        System.out.println(res);
        for(int i = 0; i < input.length; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            res = res.append(input[i]);
            recur(input, used, ans, res, k);
            res.deleteCharAt(res.length() - 1);
            used[i] =false;
        }
    }


    //根据YouTube的思路来的解法:
    //似乎这就是主要的思路,唯一解法?
    public String getPermutationB(int n, int k) {

        //1）第k个排列的第一个元素在0-n中的位置为（k-1）/（n-1）！
        //
        //2）在剩下的元素中继续找第一个；
        //
        //3）依此类推；
        if(n == 1) return "1";
        StringBuilder s1 = new StringBuilder();
        for(int i = 1; i <= n; i++){
            s1 =s1.append(i);
        }
        if(k == 1){
            return s1.toString();
        }

        int[]  factorial = new int[n];//1 to n 的 n!值数组,也就 n个
        factorial[0] = 1;
        //System.out.println(s1 + "   <--");
        for(int i = 1; i < n; i++){//存1 to n-1 的 阶乘值
            factorial[i] = factorial[i - 1] * i;
            //System.out.println( i + "  <> " + factorial[i]);
        }
        //f[0] 1, f[1]1  f[2]2  f[3]3  f[4]25 //  f.length == 5
        k = k - 1;//change to index of array转换为坐标
        StringBuilder res = new StringBuilder();
        for(int i = n; i > 0; i--){

            //还是理解困难
            int idx = k / factorial[i - 1];//就是这句! 第k个排列的第一个元素在0-n中的位置为（k-1）/（n-1）！ 题眼
            System.out.println(idx + "  <idx    i> "+ i);
            k = k % factorial[i - 1];
            res.append(s1.charAt(idx) - '0');
           // System.out.println(idx + " <  " + "  >  " + res + "    "+factorial[i - 1]);
            s1.deleteCharAt(idx);//移除用过的 char .这句很要注意
        }
        return res.toString();
    }
        //这道题目算法上没有什么特别的，更像是一道找规律的数学题目。
    // 我们知道，n个数的permutation总共有n阶乘个，基于这个性质我们可以得到某一位对应的数字是哪一个。
    // 思路是这样的，比如当前长度是n，我们知道每个相同的起始元素对应(n-1)!个permutation，
    // 也就是(n-1)!个permutation后会换一个起始元素。因此，只要当前的k进行(n-1)!取余，
    // 得到的数字就是当前剩余数组的index，如此就可以得到对应的元素。如此递推直到数组中没有元素结束。
    // 实现中我们要维护一个数组来记录当前的元素，每次得到一个元素加入结果数组，然后从剩余数组中移除，
    // 因此空间复杂度是O(n)。时间上总共需要n个回合，而每次删除元素如果是用数组需要O(n),所以总共是O(n^2)。
    // 这里如果不移除元素也需要对元素做标记，所以要判断第一个还是个线性的操作。代码如下：

    // method 3
    public String getPermutationC(int n, int k) {
        int i = 0, j = 0;
        boolean[] isUsed = new boolean[n];  //isUsed[i]存储的是第i + 1个数是否被使用
        int[] data = new int[n];  //data[i]存储的是 i! 的结果, 并用for循环进行初始化
        data[0] = 1;
        for (i = 1; i < n; i++)
            data[i] = data[i - 1] * i;
        --k;  //进行--k的原因是因为，实际上 rank = (k - 1) / data[i]，为了减少运算量，那么就对k自减
        String result = "";
        while (--i >= 0) {
            int rank = k / data[i];  //rank表示下面需要搜寻的是第 rank + 1大的数
            for (j = 0; j <= rank; j++)
                if (isUsed[j]) rank++;  //如果第j + 1个数被使用了，那么rank自加
            isUsed[rank] = true;  //由于 j = temp + 1，被使用了，那么isUsed[temp]就被置为true
            result += j;
            k = k % data[i];
        }
        return result;
    }




    public static void main(String[] args){
        permutationSequence_060 t1 = new permutationSequence_060();
        t1.getPermutationB(3,3);
    }
}
