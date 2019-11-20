package a12;

/**
 * 186.
 * Reverse Words in a String II
 * Difficulty
 * Medium

 * Given an input string , reverse the string word by word.
 *
 * Example:
 *
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * Follow up: Could you do it in-place without allocating extra space?
 */
public class reverseWordsInAString_II_186 {
    public void reverseWords(char[] str) {
        if(str == null || str.length ==0){
            return;
        }
        int left = 0;
        int right = str.length - 1;
        rev(str, left, right);
        boolean isSet = false;
        for(int i = 0; i < str.length; i++){
            if(str[i] != ' ' && !isSet){
                left = i;
                isSet = true;
            }else if(str[i] == ' '){
                right = i - 1;
                rev(str, left, right);
                isSet = false;
            }else{

            }
        }
        //!!!!!!!!!!!!don t forget the last word!!!!!!!!!!!!!!!!!
        rev(str, left, str.length - 1);

    }
    private void rev(char[] carr, int left, int right){
        while(left <= right){
            swap(carr, left++, right--);
        }
    }
    private void swap(char[] carr, int idxa, int idxb){
            char tmp = carr[idxa];
            carr[idxa] = carr[idxb];
            carr[idxb] = tmp;
    }

    public static void main(String[] args) {
        String s1 = "is the";
        reverseWordsInAString_II_186 t = new reverseWordsInAString_II_186();
        t.reverseWords(s1.toCharArray());
        System.out.println();
    }
}
