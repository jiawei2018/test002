package a018;

import java.util.ArrayList;
import java.util.List;

public class removeinvalidParenthsis_301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return res;
        }
        recur(s, res, 0, 0, new char[]{'(', ')'});

        return res;

    }

    private void recur(String s, List<String> res, int idxi, int idxj, char[] dict) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == dict[0]) {// char == "("
                count++;
            } else if (s.charAt(i) == dict[1]) {//char is ")"
                count--;
            }
            if (count >= 0) {
                continue;
            }
            //else count <0  means ) is more than (
            //remove the first )
            for (int j = idxj; j <= i; j++) {
   //             if (s.charAt(j) == dict[1]) {
                if (s.charAt(j) == dict[1] && (j == idxj || s.charAt(j - 1) != dict[1])) {
                    recur(s.substring(0, j) + s.substring(j + 1), res, i, j, dict);
                    //break;
                }
            }
            return;// is at here
        }
        //((()) -->   ))(((
        //(()))())())
        String reversed = new StringBuilder(s).reverse().toString();
        if (dict[0] == '(') {
            recur(reversed, res, 0, 0, new char[]{')', '('});//here
        } else
            res.add(reversed);
            //return;
    }


    public static void main(String[] args) {
        removeinvalidParenthsis_301 t = new removeinvalidParenthsis_301();
        String s = "(a)())()";
        String s1 = "(j))(";
        System.out.println(t.removeInvalidParentheses(s1));
    }
}
