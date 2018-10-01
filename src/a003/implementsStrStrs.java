package a003;

/**
 * 28. Implement strStr()
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 */


public class implementsStrStrs {
    //注意题里面所说的 如果针是空string,我们返回什么???

    //这道题有很复杂的解法,kmp;;还有 要1深刻理解 string== 是不好用的 ,要用 .equals  才是保险的
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(needle.length() > haystack.length()){
            return -1;
        }


        int inlen = haystack.length();
        int findlen = needle.length();
        int gap = inlen - findlen;

        for(int i = 0; i <= gap; i++){
                System.out.println(i+"  "+gap+haystack.substring(i,i+gap));
            if(haystack.substring(i,i+findlen).equals(needle)){
                return i;
            }
        }
        return -1;//这个返回仅限于本例子.
    }

    public static void main(String[] args){
        String s1 = "";
        String s2 = "";
        implementsStrStrs t1 = new implementsStrStrs();

        System.out.println(t1.strStr(s1,s2));

    }

}
