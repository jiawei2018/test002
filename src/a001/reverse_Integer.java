package a001;
/*
7. Reverse Integer
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class reverse_Integer {

    public static void main(String[] args){
       // System.out.println(1/10);//the output is '0' !!! not 1,remember int (a / b) = 0 when a < b!!


    }

    private int reverse(int x) {//此题的可以就是 这个计算  主要是考虑溢出处理
        long res = 0;
        while(x != 0){
            res = res*10 + x%10;// x % 10  得到最后一位  123 得到 '3'
            x = x/10;//  x/10  相当于 int(x/10),去掉最后一位  3   得到 12
        }
        if (res < Integer.MIN_VALUE  || res > Integer.MAX_VALUE){
            return 0;
        }
        return (int)res;
    }
}

/*  other solutions
链接：https://www.nowcoder.com/questionTerminal/1a3de8b83d12437aa05694b90e02f47a
来源：牛客网

public class Solution {
    public int reverse(int x) {
        boolean isPos = x < 0;
        int res = Integer.parseInt(new StringBuilder("" + Math.abs(x)).reverse().toString());
        if (isPos)
            return -res;
        return res;
    }
}

链接：https://www.nowcoder.com/questionTerminal/1a3de8b83d12437aa05694b90e02f47a
来源：牛客网

//本体关键点是如何判断溢出。
//推荐解答用的是用long类型存储结果，如果结果大于0x7fffffff或者小于0x80000000就溢出
//我的解法是每次计算新的结果时，再用逆运算判断与上一次循环的结果是否相同，不同就溢出
public int reverse(int x) {
        int res=0;
        while(x!=0){
            //最后一位
            int tail=x%10;
            int newRes=res*10+tail;
            //如果newRes-tail)/10!=res说明产生了溢出
            if((newRes-tail)/10!=res)
                return 0;
            res=newRes;
            x=x/10;
        }
        return res;
    }







链接：https://www.nowcoder.com/questionTerminal/1a3de8b83d12437aa05694b90e02f47a
来源：牛客网

// 与剑指offer上的一道题很相似，要考虑溢出
public class Solution {
    public int reverse(int x) {
        if(x == 0)
            return x;

        String num = String.valueOf(x);
        int inx = 0;
        boolean minus = false;
        if(num.charAt(0) == '-'){
            minus = true;
            inx++;
        }
        long res = 0;
        for(int i = num.length() - 1; i >= inx ; i--){
            int flag = minus ? -1 : 1;
            res = res * 10 + flag * (num.charAt(i) - '0');
            if(isOverflow(res))
                return 0;
        }
        return (int) res;
    }

    public boolean isOverflow(long x){
        if(x > 0){
            if(x > 0x7fffffff)
                return true;
        }
        else{
            if(x < 0x80000000)
                return true;
        }
        return false;
    }
}









 */
