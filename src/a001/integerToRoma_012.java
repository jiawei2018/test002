package a001;

import java.util.HashMap;
import java.util.Map;

/**
 * 2. Integer to Roman
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
// * Symbol       Value
// * I             1
// * V             5
// * X             10
// * L             50
// * C             100
// * D             500
// * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
 * which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However,
 * the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine,
 * which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: C = 100, L = 50, XXX = 30 and III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class integerToRoma_012 {
    public static void main(String[] args){

    }


    public String intToRoman(int num) {//题点,一是从大到小减,二是把所有右减的例子预先给出来了;当问题正向显得很复杂时候就要试着反着想!
        int[] ns= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
       // 进一步，可以看到，罗马数字可以分为1、4、5、9这四种构成方式，而1-3999中，
        // 共有1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1，共计13种，
        // 依次分别对应"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"，
        //把出现右减的都列出来!
        StringBuilder res = new StringBuilder();
        for(int i  = 0 ; i< ns.length ; i++){
            while(num >= ns[i]){// mis  must be num >=  not ">"
                num  -= ns[i];
                res.append(strs[i]);
            }
        }

        return res.toString();
    }
}
