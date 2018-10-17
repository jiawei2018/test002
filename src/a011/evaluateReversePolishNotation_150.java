package a011;

import java.util.LinkedList;

/**
 * 150. Evaluate Reverse Polish Notation
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Note:

 Division between two integers should truncate toward zero.
 The given RPN expression is always valid.
 `That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 Example 1:

 Input: ["2", "1", "+", "3", "*"]
 Output: 9
 Explanation: ((2 + 1) * 3) = 9
 Example 2:

 Input: ["4", "13", "5", "/", "+"]
 Output: 6
 Explanation: (4 + (13 / 5)) = 6
 Example 3:

 Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 Output: 22
 Explanation:
 ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 = ((10 * (6 / (12 * -11))) + 17) + 5
 = ((10 * (6 / -132)) + 17) + 5
 = ((10 * 0) + 17) + 5
 = (0 + 17) + 5
 = 17 + 5
 = 22

 */
public class evaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {

        //此题没思路是忘了老师说的,凡是涉及经常回头看的动作,首先就要想到的是栈和队列,唉.....还是自己太没有直觉!
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        LinkedList<Integer> stres = new LinkedList<>();
        int one;
        int two;

        for(String s : tokens){
            if(s.equals("+") ){
                two = Integer.valueOf(stres.pop());
                one = Integer.valueOf(stres.pop());
                stres.push(one + two);
            }
            else if(s.equals("-") ){
                two = Integer.valueOf(stres.pop());
                one = Integer.valueOf(stres.pop());
                stres.push(one - two);
            }
            else if(s.equals("*") ){
                two = Integer.valueOf(stres.pop());
                one = Integer.valueOf(stres.pop());
                stres.push(one * two);
            }
            else if(s.equals("/") ){
                two = Integer.valueOf(stres.pop());
                one = Integer.valueOf(stres.pop());
                stres.push(one / two);
            }else//此处出错是怪自己粗心和理解不够 // 没有else 则后面会 出现执行完上面的右执行一次压栈的动作.....
            stres.push(Integer.valueOf(s));
        }
        return stres.pop();
    }


    public static void main(String[] args) {
        String[] in = {"2","1","+","3","*"};
        evaluateReversePolishNotation_150 t = new evaluateReversePolishNotation_150();
        System.out.println(t.evalRPN(in));

    }


}
