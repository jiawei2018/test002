package a001;

/**
 * 10. Regular Expression Matching
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */

//来自老手的指点:
/*做了很多leetcode题目，我们来总结一下套路：
首先一般是检查输入参数是否正确，然后是处理算法的特殊情况，之后就是实现逻辑，最后就是返回值。
当编程成为一种解决问题的习惯，我们就成为了一名纯粹的程序员
/*/
public class regularExporesionMatchingH {

    public boolean isMatch(String s, String p) {//dp

  return false;

    }

    public static void main(String[] args){

    }

}
