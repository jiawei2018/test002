package a12;

import java.util.LinkedList;
import java.util.List;

/**
 * 168. Excel Sheet Column Title
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */
public class excelSheetColumnTtile {
    public static void main(String[] args) {
        System.out.println(701 / 26);
        excelSheetColumnTtile t = new excelSheetColumnTtile();
        System.out.println(t.convertToTitle(52));
    }
    public String convertToTitle(int n) {
        if(n <= 0){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        while(n > 0){
             stack.push((n - 1) % 26); //key is here!!!!!!!must be ,think10进制,到9就要进位了......
             n = (n - 1) / 26;//key is here!!!!!!!must be ,think10进制,到9就要进位了......
        }
        String res = intTOChar(stack);
        return res;
    }

    private String intTOChar(LinkedList<Integer> stack){//use as stack;
        char[] dic = new char[26];
        int a = 'A';
        for(int i = 0; i < 26; i++){
            dic[i] = (char)a++;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(dic[stack.pop()]);
        }
        return sb.toString();
    }
}
