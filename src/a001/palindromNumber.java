package a001;

/**
 * 9. Palindrome Number
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 */

public class palindromNumber {
    public static void main(String[] args){
        palindromNumber p = new palindromNumber();
        p.isPalindrome(12345321);
       // p.isPalindrome(12321);

    }


    private boolean isPalindrome(int x) {
        if(x <0 || x%10 == 0 && x != 0){
            return false;
        }

        int   rNum = 0;
        while(x > rNum){//niu bbbbbbb!!!!   左边一次除10,右边一次乘10.所以是从两边往中间走
            rNum = rNum *10 +x%10;
            x /= 10 ;
            //System.out.println(x+"<<<<<<<<<<<<<<");
           // System.out.println(rNum + "<><><><>");
        }
        return  x == rNum ||x ==rNum /10;//此处很重要!
        }
}



/*
方法一：

      第一反应就是将整数转换为字符串，然后检查字符串是否是回文。但创建字符串需要O(n)的(非常量)空间，这与题目的要求是不符合的。

      第二个想法是，将整数本身逆序，然后将逆序后的整数和原来的整数进行比较。如果它们相同，那么一定是回文数。
      但是，需要注意的是，逆序后的数字可能>int.Max。这会导致溢出。

      为了避免产生溢出问题，我们可以只逆序整数的一半。回文数的后半部分的逆序应该和回文数的前半部分相同。  -- 重点 ,敲黑板

      举个例子，如果输入的是“1221”，我们可以将“1221”的后半部分从“21”逆序为“12”，并与“1221”的前半部分进行比较。

      如果相同，那么就是一个回文数。

      对于整数“1221”，通过“1221%10”，我们就可以得到最后一位“1”。可以把“1221/10 =122”，再“122%10”，我们就可以得到倒数第二位了。

      重复这样的过程，直到这个整数的中间位置。

      然后，通过“1*10+2=12”就能得到整数后半部分的逆序了。

      现在问题的关键是，我们如何知道，我们已经到了这个整数的中间位置了。

      当逆序后的数的值大于原来的值的时候，就到了这个整数的中间位置了。

class Solution {
    public boolean isPalindrome(int x) { --- 真牛逼!
        //1.所有的负数不是回文数
        //2.如果这个整数的最后一位是0，那么只有这个数是0的时候才是回文数。如果不是0，那么就不是回文数
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;                         //注意这个过程
        }

        return x == revertedNumber || x == revertedNumber/10;
    }
}
时间和空间复杂度分析

       时间复杂度为：O(log N)

       空间复杂度为：O(1)
 */