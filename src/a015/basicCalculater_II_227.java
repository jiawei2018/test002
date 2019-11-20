package a015;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 227.
 * Basic Calculator II
 * Difficulty
 * Medium

 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class basicCalculater_II_227 {
    public static void main(String[] args) {
        String st = "3+2*2";
        basicCalculater_II_227 t = new basicCalculater_II_227();
        t.calculate(st);
    }
    public int calculate(String s) {
       // s.trim();
        if (s.length() < 1) {
            return 0;
        }
        /**
         *   12 * 3
         *   13 - 5
         *
         */
        //
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';//mistake keypoint
        //trans to solve "+3-2*2"
            for (int i = 0; i < s.length(); i++) {
            //contains only non-negative integers
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    //is a digit
                    num = num * 10 + s.charAt(i) - '0';
                }
                if (i == s.length() - 1 || (s.charAt(i) < '0' || s.charAt(i) > '9') && ( s.charAt(i) != ' ')){//mistake
                    //上面这句话意思是,这或者是最后一个元素,或者是个符号
                        //这个用法十分重要!!!!!!!!!!!!
                        if (sign == '+') {//第一次,或者说首数字一定是sign = +的, sign 只有在下面才会第一次赋值
                            stack.push(num);
                        }
                        if (sign == '-') {
                            stack.push(-num);
                        }
                        if (sign == '*') {
                            stack.push(stack.pop() * num);
                        }
                        if (sign == '/') {
                            stack.push(stack.pop() / num);
                        }
                        sign = s.charAt(i);//当前的符号,第一次赋值发生在这里
                        num = 0;
                }
            }
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}