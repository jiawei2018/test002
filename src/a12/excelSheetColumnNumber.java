package a12;

import java.util.LinkedList;

/**
 * 171.
 * Excel Sheet Column Number

 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 */
public class excelSheetColumnNumber {
    public static void main(String[] args) {
        excelSheetColumnNumber t = new excelSheetColumnNumber();
        System.out.println(t.titleToNumbera("ZY"));
    }

    public int titleToNumbera(String s) {
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            int tmp = (s.charAt(i) - 'A') + 1;
            res = res*26 + tmp;
        }

        return res;
    }


    public int titleToNumber(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        int res = 0;
        int exp = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            res += (int)intTOChar(s.charAt(i))* Math.pow(26,exp++);
        }
        return res;
    }
    private int intTOChar(char c){//use as stack;
        char[] dic = new char[27];
        int a = 'A';
        int res = 0;
        for(int i = 1; i < 27; i++){
            dic[i] = (char)a++;
        }
        for(int i = 1; i < 27; i++){
            if(dic[i] == c){
               res = i;
               return res;
            }
        }
        return -1;
    }
}
