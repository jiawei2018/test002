package a011;


/**
 * 161. One Edit Distance
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given two strings s and t, determine if they are both one edit distance apart.
 * <p>
 * Note:
 * <p>
 * There are 3 possiblities to satisify one edit distance apart:
 * <p>
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 * Example 1:
 * <p>
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * Example 2:
 * <p>
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * Example 3:
 * <p>
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.0
 */
public class oneEditDistance_161 {
    public boolean isOneEditDistance(String s, String t) {
        //must be distance == 1!not a == b
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() == t.length()) {
            return getDiffEqual(s, t);
        } else
            return getDiffNotequal(s, t);
    }

    private boolean getDiffNotequal(String s, String t) {
        int diff = 0;
        String ll;//longer one
        String ss;//shorter one
        if (s.length() < t.length()) {
            ll = t;
            ss = s;
        } else {
            ll = s;
            ss = t;
        }

        for (int i = 0, j = 0; i < ss.length() && j < ll.length(); i++, j++) {
            System.out.println(i + " " + j + " " + ss.length() + "  " + ll.length());
            if (ss.charAt(i) != ll.charAt(j)) {
                diff++;
                i--;
            }
        }
        return diff <= 1;
    }

    private boolean getDiffEqual(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    //from cssdn
    //理解,这个,有是dp
    public int minDistance(String word1, String word2) {
        int lenA = word1.length();
        int lenB = word2.length();
        int[][] dp = new int[lenA + 1][lenB + 1];

        if (lenA == 0) return lenB;
        if (lenB == 0) return lenA;

        for (int i = 0; i < lenA + 1; i++)
            dp[i][0] = i;
        for (int i = 0; i < lenB + 1; i++)
            dp[0][i] = i;

        for (int i = 1; i < lenA + 1; i++) {
            for (int j = 1; j < lenB + 1; j++) {
                //dp[i][j]  VS dp[i][j-1]+1(cost) for delete  VS dp[i-1][j] +1(cost) for insert VS
                // dp[i-1][j-1] + cost for substitution
                int cost = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + cost, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));//三选最小

            }
        }
        return dp[lenA][lenB];
    }


    public static void main(String[] args) {
        String a = "";
        String b = "";
        oneEditDistance_161 t = new oneEditDistance_161();

        System.out.println(t.isOneEditDistance(b, a));

    }
}
