package lai0000.c001;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 All Valid Permutations Of Parentheses II
 Description
 Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

 Assumptions

 l, m, n >= 0
 Examples

 l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
 */
public class allpermutations_II {
    public static void main(String[] args) {
        allpermutations_II t = new allpermutations_II();
        System.out.println(t.validParentheses(0,0,0));
    }
    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        if(l == 0 && m == 0 && n ==0){
            return res;
        }
        Deque<Character> stack = new ArrayDeque<>();
        int[] remain = new int[]{l,l,m,m,n,n};
        int len = 2 * (l + m + n);
        char[] ps = new char[]{'(',')','<','>','{','}'};
        recur(remain, res, stack, new StringBuilder(),len,ps);
        return res;
    }

    private void recur(int[] remain,List<String> res, Deque<Character> stack, StringBuilder temp, int targetLen, char[] dict){
        if(temp.length() == targetLen){
            res.add(temp.toString());
            return;
        }

        //l pairs of (), m pairs of <> and n pairs of {}.
        for(int i = 0; i < remain.length; i++){
            if(i % 2 == 0){// i is the (,<,{  array start from 0;!
                if(remain[i] > 0){
                    temp.append(dict[i]);
                    stack.push(dict[i]);
                    remain[i]--;
                    recur(remain, res, stack, temp, targetLen, dict);
                    temp.deleteCharAt(temp.length() - 1);
                    stack.pop();
                    remain[i]++;
                }

            }else{ // char is ) > }
                if(!stack.isEmpty() && stack.peek() == dict[i - 1]){
                    temp.append(dict[i]);
                    stack.pop();
                    remain[i]--;
                    recur(remain, res, stack, temp, targetLen, dict);
                    temp.deleteCharAt(temp.length() - 1);
                    stack.push(dict[i - 1]);
                    remain[i]++;

                }
            }

        }//for

    }//recursion


}
