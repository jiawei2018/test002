package a002;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */

public class validParentheses_020 {

    public boolean isValid(String s) {//虽然是简单,但是还看了思路,说明以前的都忘了.......唉......不后悔!

        if(s.length()%2 != 0 ){
            return false;
        }
        Stack<Character> st = new Stack();

        for(char c:s.toCharArray()){
            if(st.isEmpty() && (c == ')' || c == '}'||c == ']')) return false;//边界
            if(c == '(' || c == '{'||c == '[') st.push(c);

            if(c == ')'){
                if(st.peek() == '('){
                    st.pop();
                }else return false;
            }

            if(c == ']'){
                if(st.peek() == '['){
                    st.pop();
                }else return false;
            }

            if(c == '}'){
                if(st.peek() == '{'){
                    st.pop();
                }else return false;
            }
        }

        return st.isEmpty();
    }



    //网络答案,最简洁的
    /*
     1     public boolean isValid(String s) {
 2         char[] sc = s.toCharArray();
 3         Stack<Character> stack = new Stack<Character>();
 4         for(int i = 0; i<s.length(); i++) {
 5             switch (sc[i]) {
 6                 case ')':
 7                     if (stack.empty() || stack.pop() != '(')
 8                         return false;
 9                     break;
10                 case '}':
11                     if (stack.empty() || stack.pop() != '{')
12                         return false;
13                     break;
14                 case ']':
15                     if (stack.empty() || stack.pop() != '[')
16                         return false;
17                     break;
18                 default:
19                     stack.push(sc[i]);
20             }
21         }
22         return stack.empty();
23     }
     */

        public static void main(String[] args){

        }

}
