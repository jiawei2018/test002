package googlle;

public class lc471stringEncode {

    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];//shorest encoded string for substring[i][j]
        for (int len = 1; len <= n; len++) {//substring's length
            //a s d f e d s
            //ex. len = 2 ->
            for (int left = 0; left + len - 1 < n; left++) {//problem like the problem burst ballom
                //先确定最小的window是啥
                int right = left + len - 1;
                dp[left][right] = s.substring(left, right + 1);
                //first we set the whole substring as not encoded string
                for (int k = left; k < right; ++k) {
                    //a s d    f    e d s
                    //0 1 2 3 4 5 6
                    if (dp[left][k].length() + dp[k + 1][right].length() < dp[left][right].length()) {
                        dp[left][right] = dp[left][k] + dp[k + 1][right];
                    }
                }
                // string left to right
                String current = s.substring(left, right + 1);
                int idx = (current + current).indexOf(current, 1);
                /*
                important line abcabc .indexof
                aaa-> 3
                aaaaaa
                 aaa idx = 1
                  aa

              abab abab
                ab ab
                找出最短重复块!
                  too tricky   so we need to get another function to solve this one
                */
                if (idx < current.length()) {
                    current = String.valueOf(current.length() / idx) + "[" + dp[left][left + idx - 1] + "]";
                }


                if (current.length() < dp[left][right].length()) {
                    dp[left][right] = current;//cannot compress
                }
            }
        }
        return dp[0][n - 1];
    }



    private String getShortestRepeatedSubstring(String str){
        String strstr = str + str;
        int idx = strstr.indexOf(str, 1);
        if(idx < str.length()){//there exist an repblock
            System.out.println(str.length() / idx);//how many times an rep exist in a string
            return str.substring(0, idx);//[left, right);
        }
        return str;
    }
}
