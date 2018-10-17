package a011;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 * * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 * <p>
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */
public class fractionToRecurringDecimal_166 {
    public static void main(String[] args) {
        fractionToRecurringDecimal_166 t = new fractionToRecurringDecimal_166();
        t.fractionToDecimal(-1,        -2147483648);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return String.valueOf(0);
        }
        if(denominator == 0){
            return "error";
        }
        StringBuilder sb = new StringBuilder();

        if((numerator < 0)^(denominator < 0)){//if different is true   // Tip
            sb.append("-");
        }
        //必须先long在abs,否则因为负数比正数最大值大一,无法转化为正数

        long uppart = Math.abs((long)numerator);
        long downpart = Math.abs((long)denominator);
        long front = uppart / downpart;
        long remainder = uppart % downpart;
        sb.append(String.valueOf(front));
        if(remainder == 0){
            return sb.toString();
        }
        sb.append(".");
        int beginIdx = sb.length();
        Map<Long, Integer> map = new HashMap<>();
        //String res = "";
        while(remainder > 0){
            remainder *= 10;
            front = remainder / downpart;
            if(map.containsKey(remainder)){
                sb.insert(map.get(remainder),"(");
                sb.append(")");
                break;
            }else{
                map.put(remainder, beginIdx);
                sb.append(front);
            }
            remainder %= downpart;
            beginIdx++;
        }

        return  sb.toString();
    }

    public String fractionToDecimalA(int numerator, int denominator) {

        /**首先考虑除数为0，被除数为0的特殊情况*/
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return String.valueOf(Integer.MAX_VALUE);
        }

        /**其次考虑两个数的符号不一致的情况*/
        String res = new String();
        if ((numerator < 0) ^ (denominator < 0)){//XOR means when equal false, not equal true
            res = res + "-";
        }
        //a⊕b = (¬a ∧ b) ∨ (a ∧¬b)
        //如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。

        /**考虑到Int类型为-2^32的溢出，所以转化为long，一定要先转换再求绝对值
         * 既然已经考虑了符号，就可以直接转为绝对值**/
        long upper = Math.abs((long) numerator);
        long down = Math.abs((long) denominator);

        /**区别整数部分和小数部分*/
        long front = upper / down;
        long remainder = upper % down;
        res = res + String.valueOf(front);

        /**没有小数部分，直接返回**/
        if (remainder == 0) {
            return res;
        }
        res += '.';

        //首先，考虑到整数除法是怎么实现的，依次向下除，取余。那
        // 么，什么时候出现循环呢？当余数重复的时候出现循环。
        // 知道这个规则就可以很顺利的设计我们的算法了。
        // 就是要注意很多细节的处理，我都在代码中注明了。
        /**采用map来存储余数，以及该余数对应的小数的位置，这样方便我们为循环小数打括号*/
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int beginIdx = res.length();
        while (remainder > 0) {
            remainder = remainder * 10;
            front = remainder / down;
            /**如果出现重复，需要截取出循环的部分打括号**/
            if (map.containsKey(remainder)) {
                /**循环前**/
                String part1 = res.substring(0, map.get(remainder));
                /** 循环后*/
                String part2 = res.substring(map.get(remainder));
                res = part1 + "(" + part2 + ")";
                break;
            } else {
                res += String.valueOf(front);
                map.put(remainder, beginIdx);
            }
            /**更新位置计数和余数**/
            beginIdx++;
            remainder = remainder % down;
        }

        return res;

    }



}
