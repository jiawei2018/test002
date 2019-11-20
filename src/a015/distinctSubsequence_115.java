package a015;

public class distinctSubsequence_115 {

    public int numDistinct(String s, String t) {
        //see the output is int so it is definitely DP
        //dp is always hard

        int[][] res = new int[s.length() + 1][t.length() + 1];//most the time + 1
        // res[i][j] means tille i ,j the distinct sub sqeuence we have or the answer
        for (int i = 0; i < s.length(); i++) {//base case
            res[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
                    // s: gbb   t: hb
                    // both del last 'b'  -> gb  ,  h
                    //or s del last  -. gb , hb
                } else {
                    res[i][j] = res[i - 1][j];
                }
            }
        }
        return res[s.length()][t.length()];
    }
}
