package a011;

import java.util.LinkedList;
import java.util.List;

/**
 * 151. Reverse Words in a String
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Given an input string, reverse the string word by word.

 Example:

 Input: "the sky is blue",
 Output: "blue is sky the".
 Note:

 A word is defined as a sequence of non-space characters.
 Input string may contain leading or trailing spaces.
 However, your reversed string should not contain leading or trailing spaces.
 You need to reduce multiple spaces between two words to a single space in the reversed string.
 Follow up: For C programmers, try to solve it in-place in O(1) space.


 */
public class reverseWordsInAString_151 {
    public String reverseWords(String s) {
        if(s == null || s.length() ==0){
            return s;
        }
        StringBuilder res = new StringBuilder();
        LinkedList<String> ststr = new LinkedList<>();

        String[] tmp = s.trim().split(" ");
        for(String i : tmp){
            System.out.println(i + "<");
            if(i.length() != 0) {
                ststr.push(i);
            }
        }
        while(!ststr.isEmpty()){
            res = res.append(ststr.pop());
            res.append(" ");
        }
        return res.toString().trim();
    }


    public String reverseWordsB(String s) {
            int storeIndex = 0, len = s.length();

            StringBuilder sb = new StringBuilder(s).reverse();

            for (int i = 0; i < len; ++i) {
                if (sb.charAt(i) != ' ') {//first not null

                    if (storeIndex != 0) {
                        sb.setCharAt(storeIndex++, ' ');
                    }
                    int j = i;
                    while (j < len && sb.charAt(j) != ' ') {
                        sb.setCharAt(storeIndex++, sb.charAt(j++));
                    }
                    // j - i =word length
                    //storeIndex - (j - i), storeIndex   so is the idx start and idx end
                    String str = new StringBuilder(sb.substring(storeIndex - (j - i), storeIndex)).reverse().toString();
                    sb.replace(storeIndex - (j - i), storeIndex, str);
                    i = j;
                }
            }
            sb.setLength(storeIndex);
            return sb.toString();
    }



    public static void main(String[] args) {
        String s = "   a   b ";
        String s1 = "  the sky is blue ";
        reverseWordsInAString_151 t = new reverseWordsInAString_151();
        System.out.println(t.reverseWordsB(s1));

    }
}
