package a001;

/**
 * 8. String to Integer (atoi)
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 * * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * * If no valid conversion could be performed, a zero value is returned.
 * * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values,
 * INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 */
public class StringToInteger {

    private int myAtoi(String str) {

        str = str.trim();//cut the whiteBreaks
        if(str == null || str.length() == 0) return 0;//this must after above line!!!!!! mistake appear
        int sign = 1;
        int idx = 0;

        if(str.charAt(idx) == '-'){
            sign = -1;
            idx++;
        }else if (str.charAt(idx) == '+'){
            idx++;
        }


        long num = 0 ;
        for(;idx < str.length();idx++){
            if(str.charAt(idx) < '0' || str.charAt(idx) > '9'){//must be '0'  not 0!!1 mistake
                break;
            }
            num = num*10 + str.charAt(idx)-'0';//digi by digi plus
            if(num > Integer.MAX_VALUE){
                break;
            }
        }


        if(num>Integer.MAX_VALUE){
            if(sign >0 ){
                return Integer.MAX_VALUE;
            }
            if(sign < 0){
                return Integer.MIN_VALUE;
            }
        }
        return (int)num*sign;
    }
    public static void main(String[] args){

    }
}

/**
 *  复杂度
 * 时间 O(n) 空间 O(1)
 *
 * 思路
 * 字符串题一般考查的都是边界条件、特殊情况的处理。所以遇到此题一定要问清楚各种条件下的输入输出应该是什么样的。这里已知的特殊情况有：
 * key notes
 * 能够排除首部的空格，从第一个非空字符开始计算
 * 允许数字以正负号(+-)开头
 * 遇到非法字符便停止转换，返回当前已经转换的值，如果开头就是非法字符则返回0
 * 在转换结果溢出时返回特定值，这里是最大/最小整数
 */

/*
注意
检查溢出时最大整数要先减去即将加的最末位再除以10，来处理"2147483648"类似的情况  --此处重点!
可以参考glibc中stdlib/atoi.c的实现方法

    public int myAtoi(String str) {
        str = str.trim();//删除头尾空格,  1
        int result = 0;
        boolean isPos = true;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(i==0 && (c=='-'||c=='+')){
                isPos = c=='+'?true:false;
            } else if (c>='0' && c<='9'){
                // 检查溢出情况
                if(result>(Integer.MAX_VALUE - (c - '0'))/10){
                    return isPos? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result *= 10;
                result += c - '0';
            } else {
                return isPos?result:-result;
            }
        }
        return isPos?result:-result;
    }
 */


/*
9章answwer
   public int myAtoi(String str) {
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int sign = 1;
        int index = 0;

        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        long num = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            num = num * 10 + (str.charAt(index) - '0');
            if (num > Integer.MAX_VALUE ) {
                break;
            }
        }
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;
    }
 */