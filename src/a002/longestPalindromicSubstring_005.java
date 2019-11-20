package a002;

/**
 * 5. Longest Palindromic Substring
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class longestPalindromicSubstring_005 {
    public static void main(String[] args){

        String s="babad";
        longestPalindromicSubstring_005  t = new longestPalindromicSubstring_005();
        System.out.println(t.longestPalindrome(s));

    }

    private String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        int lp = 1;
        String lpstr = s.substring(0,1);

        for(int i =0 ; i < s.length() ; i++){
            String lpodd = centerS(s,i,i);
            String lpeven =  centerS(s,i,i+1);
            String maxstr = lpodd.length() > lpeven.length() ? lpodd : lpeven;
            if(maxstr.length() > lp){
                lp = maxstr.length();
                lpstr = maxstr;
            }
        }
        return lpstr;
    }

    private String centerS(String str ,  int left , int right){
        while(left >=0 && right < str.length() && (str.charAt(left ) == str.charAt(right))){
            left--;
            right++;
        }
        //System.out.println(left+"<<    " + right +">>");
        //at here left != right,so the rrange will be left+1 to right-1
        return str.substring(left+1,right);//为什么不是right-1??只有left+1? 此处不理解
        //public String substring(int beginIndex,
        //               int endIndex)
        //Returns a new string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.
        //Examples:
        //
        // "hamburger".substring(4, 8) returns "urge"
        // "smiles".substring(1, 5) returns "mile"
        //
        //Parameters:
        //beginIndex - the beginning index, inclusive.
        //endIndex - the ending index, exclusive.

        //此处大概因为substring的特点,取上一个是lp的时候是坐标
       // 比如 babad
       //         aba是,扩散以后 babad 不是,
       //         此时left+1,回去了,right不用变因为aba的第三个a正好就是 substring所需要的坐标4.....


        // 这里要特别小心，跳出 while 循环的时候，是第 1 个满足 s.charAt(l) != s.charAt(r) 的时候
        // 所以，不能取 l，不能取 r
    }
}


/*  dp答案

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];
        // abcdedcba
        //   j   i
        // 如果 dp[j,i] = true 那么 dp[j+1,i-1] 也一定为 true
        // [j+1,i-1] 一定要构成至少两个元素额区间（ 1 个元素的区间，s.charAt(i)==s.charAt(j) 已经判断过了）
        // 即 j+1 < i-1，即 i > j + 2 (不能取等号，取到等号，就退化成 1 个元素的情况了)
        // 应该反过来写
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                // 区间应该慢慢放大
                if (s.charAt(i) == s.charAt(j) && (i <= j + 2 || dp[j + 1][i - 1])) {
                    // 写成 dp[j][i] 就大错特错了，不要顺手写习惯了
                    dp[j][i] = true;
                    if (i - j + 1 > longestPalindrome) {
                        longestPalindrome = i - j + 1;
                        longestPalindromeStr = s.substring(j, i + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }
 */


/*
求解关键：回文

思路1：中心扩散法：枚举回文串的中心（注意分回文串是奇数还是偶数时候的判断，可以同一设计一个方法），得到回文串，从中统计中最长的回文串即可。

思路2：动态规划方法。

思路3：专门解决回文串的一个著名算法 Manacher 算法。
 */


//    public String longestPalindrome(String s) {
//        if(s == null || s.length() == 1){
//            return ture;
//        }
//        int maxLen = 0;
//        String res = "";
//        String cur;//for aba
//        String curodd;//for abba
//
//        for(int i = 0; i < s.length(); i++){
//            cur = getp(s, i , i);
//            curodd = getp(s, i , i + 1);
//            String tmp = cur.length() > curodd.length() ? cur : curodd;
//            res = tmp.length() > maxLen ? tmp : res;
//        }
//        return res;
//    }
//
//    private void getp(String str, int left, int right){
//        while(left >= 0 && right < str.length() && (str.charAt(left) == str.charAt(right))){
//            left--;
//            right++;
//        }
//
//        return str.substring(left + 1, right);
//
//    }