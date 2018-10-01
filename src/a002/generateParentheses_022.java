package a002;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

//recursion , dfs,bfs 都是代码简单,但是思路复杂,就刷题来说是有套路的

public class generateParentheses_022 {


    //本题思路:递归实现，如果左括号还有剩余，则可以放置左括号，如果右括号的剩余数大于左括号，则可以放置右括号。
    //本题就是构造,反向思维!!! 1.必选全用完,2.必须成对,3.必须先有左面的,即'(' 再')'

    public List<String> generateParenthesis(int n) {
        if(n == 0 ){
            return null;
        }
        //if n = 1 ,return "()";
        List<String> res = new ArrayList<>();
        gP(n,n,"",res);
        return res;
    }

    private void gP(int lefts, int rights, String gstr, List<String> res){//以后要有直觉,好嗲推断出来有哪些参数!
        //num off left?   num of right?   String till now ,  answers
        if(lefts == 0 && rights == 0 ){
            res.add(gstr);
        }

        if(lefts > 0){//mistake this line ,left only > 0
            gP(lefts -1 ,rights,gstr+"(",res);
        }  //注意此处,我不是 if-else关系,是 两个独立的 if
        if(lefts < rights){
            gP(lefts ,rights-1,gstr+")",res);
        }
    }

    public static void main(String[] args){

    }
}
