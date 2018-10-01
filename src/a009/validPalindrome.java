package a009;

/**
 * 125. Valid Palindrome
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class validPalindrome {

    public boolean isPalindrome(String s) {//要多抽出method, 多想Siva额教诲
        String str = s.toLowerCase();
        System.out.println(str);
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i <str.length(); i++){
            if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= '0' && str.charAt(i) <= '9') ){
                tmp.append(str.charAt(i));
            }
        }
        System.out.println(tmp);
        int left = 0;
        int right = tmp.length() - 1;

        while(right > left){
            System.out.println(left + " <>  " + right);
            if(tmp.charAt(right) == tmp.charAt(left)){
                right--;
                left++;
            }else
                return false;
        }
        return true;
    }

    /**
     * public boolean isPalindrome(String s) {
     *     if (s == null || s.length() <= 1)
     *         return true;
     *     for (int i=0, j=s.length()-1; i<=j; ) {
     *         char ch1 = s.charAt(i);
     *         char ch2 = s.charAt(j);
     *         if (isValidChar(ch1) && isValidChar(ch2)) {
     *             if(Character.toLowerCase(ch1) == Character.toLowerCase(ch2)) {
     *                 i++;
     *                 j--;
     *             } else {
     *                 return false;
     *             }
     *         } else if (!isValidChar(ch1)){
     *             i++;
     *         } else if (!isValidChar(ch2)) {
     *             j--;
     *         }
     *     }
     *     return true;
     * }
     * public boolean isValidChar(char ch1) {

     *         int delta = 'A' - 'a';  //此处妙啊

     *         while (left < right) {
     *             while (left < s.length() && !isAlphanumericCharacters(s.charAt(left))) { // 从左向右找数字与字母
     *                 left++;
     *             }
     *
     *             while (right >= 0 && !isAlphanumericCharacters(s.charAt(right))) { // 从右向左找数字与字母
     *                 right--;
     *             }
     *
     *             if (left < right) {
     *                 l = s.charAt(left);
     *                 r = s.charAt(right);
     *                 if (l == r || l - r == delta || r - l == delta) {
     *                     left++;
     *                     right--;
     *                 } else {
     *                     return false;
     *
     *
     *
     * @param args
     */



    public static void main(String[] args) {
        validPalindrome t = new validPalindrome();
        String s = "A man, a plan, a canal: Panama";
        t.isPalindrome(s);
    }

}
