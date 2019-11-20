package a018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 273. Integer to English Words
 * Hard
 * <p>
 * 441
 * <p>
 * 1128
 * <p>
 * Favorite
 * <p>
 * Share
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * <p>
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * <p>
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * <p>
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class IntegerToEnglishWords_273H {
    public String numberToWords(int num) {
        String[] one = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};

        String[] tys = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty"};
        String[] carry = {"", "thousand", "million", "billion"};

        Map<Integer, Integer> map = new HashMap<>();
        for (int j : map.keySet()) {

        }
        return null;
    }

    private void recur(List<String> res, String num, int target, StringBuilder prefix, int pos, int preValue, int value) {
        if (pos == num.length()) {
            if (value == target) {
                res.add(prefix.toString());//here for prefix we only use string NOT stringBuilder
                return;
            }
        }
        //prevalue is for multiple
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            String cur = num.substring(pos, i + 1);
            int len = prefix.length();
            int curint = Integer.valueOf(cur);
            if (pos == 0) {
                recur(res, num, target, prefix.append(curint), i + 1, curint, curint);
                prefix.setLength(len);
            } else {
                recur(res, num, target, prefix.append("+").append(curint), i + 1, value, value + curint);
                prefix.setLength(len);
                recur(res, num, target, prefix.append("-").append(curint), i + 1, value, value - curint);
                prefix.setLength(len);
                recur(res, num, target, prefix.append("*").append(curint), i + 1, curint * preValue, (value - preValue) + curint * preValue);
                prefix.setLength(len);
            }
        }
    }

    //foir leetcode 282
    public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) {
        if (pos == num.length()) {
            if (target == prev) res.add(sb.toString());
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (num.charAt(pos) == '0' && i != pos) {
                break; //That's for 0 sequence number, the number starts with "0"
                // can only be '0'  NOT '02' or '023'
            }
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if (pos == 0) {
                dfs(res, sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr);
                sb.setLength(len);
                dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr);
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }

    public List<String> t2(String num, int target) {
        List<String> res = new ArrayList<>();

        recur(res, num, target, new StringBuilder(), 0, 0, 0);
        return res;


    }

    public static void main(String[] args) {
        IntegerToEnglishWords_273H t = new IntegerToEnglishWords_273H();
        System.out.println(t.t2("105", 5));
    }


}
