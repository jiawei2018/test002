package h001;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return go(s.toCharArray(), 0, wordDict, new boolean[s.length()]);
    }

//    public static boolean go(char[] target, int idx, List<String> dict, int[] dp) {
//        if (idx == target.length) {
//            return true;
//        }
//        if (dp[idx] == 1) {
//            return false;
//        }
//        for (String word : dict) {
//            char[] curr = word.toCharArray();
//            if (idx + curr.length <= target.length) {
//                if (compare(target, curr, idx) && go(target, idx + curr.length, dict, dp)) {
//                    return true;
//                }
//            }
//        }
//        dp[idx] = 1;
//        return false;
//    }


    public static boolean go(char[] target, int idx, List<String> dict, boolean[] mem) {
        if (idx == target.length) {
            return true;
        }
        if (mem[idx]) {
            return false;
        }
        for (String word : dict) {//chk every dict word
            char[] curr = word.toCharArray();//to char[] not to use string
            if (idx + curr.length <= target.length) {//make sure the len is valid
                if (compare(target, curr, idx) && go(target, idx + curr.length, dict, mem)) {
                    //compare make sure this word is in string
                    //recur to chk rest part
                    return true;
                }
            }
        }
        mem[idx] = true;
        return false;
    }

    private static boolean compare(char[] target, char[] curr, int idx) {
        int length = curr.length;
        for (int i = 0; i < length; i++) {
            if (target[idx + i] != curr[i]) return false;
        }
        return true;
    }


    public boolean wordBreak1(String s, List<String> wordDict) {
        if(s == null || wordDict == null){
            return false;
        }
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        boolean[] res = new boolean[s.length()];

        for(int i = 1 ; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String tmp = s.substring(j, i);
                if(set.contains(tmp) && (j == 0 || res[j - 1] == true)){//顺序绝对不能错!!!!!!!!!!
                    res[i - 1] = true;
                    break;
                }

            }
        }

        return res[s.length() - 1];

    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

    }
}
