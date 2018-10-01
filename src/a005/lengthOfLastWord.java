package a005;

/**
 * 58. Length of Last Word
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class lengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if(s.length() == 0 || s == null) return 0;
        // if(s.charAt(s.length() - 1) == ' ') return 0;
        int sum = 0;
        for(int i = s.length() -1; i >=0; i--){
            if (sum == 0 && s.charAt(i) == ' ')    continue ;  //本题的题眼在此处
            if(s.charAt(i) != ' '){
                sum++;
            }else
                break;
        }
        return sum;
    }
}
