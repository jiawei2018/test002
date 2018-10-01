package a001;

/**
 * 13. Roman to Integer
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: C = 100, L = 50, XXX = 30 and III = 3.
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class romaToInteger_013 {
    public static void main(String[]  args){

    }

    private int romanToInt(String s) {//这个题 一是 要用从第二位开始,于是里面就变成 i 和 i-1 的形式了,像这这种最后一位可能出现
        //题设特殊条件的,边界问题这样处理更好!思维起来也简单
        //all 4,9 s?
        // left < right ,then this will be right - left

        if(s == null || s.length() == 0 ) return 0;
        int res = charToNum(s.charAt(0)) ;
        for(int i = 1 ; i<s.length();i++){
            //正算的形式,需要处理边界问题,对于最后一位的处理复杂,
            //但是反算就不会, 处理起来很简单
            if(charToNum(s.charAt(i)) > charToNum(s.charAt(i-1))){
                res += charToNum(s.charAt(i)) - 2*charToNum(s.charAt(i-1));//因为之前加过一个charat(i),所以要减2次这个i 锁代表的值
            }else{
                res += charToNum(s.charAt(i));
            }
        }
        return res;
    }

    private  static int charToNum(char c){
        int res = 0 ;
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return res;

    }

}
