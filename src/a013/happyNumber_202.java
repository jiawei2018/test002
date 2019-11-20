package a013;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 202.
 * Happy Number
 * Difficulty
 * Easy

 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class happyNumber_202     {
    public static void main(String[] args) {
        happyNumber_202 t = new happyNumber_202();
        System.out.println(t.isHappy(1999999));
    }
    public boolean isHappy(int n) {
        if(n <= 0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int tmp = n;
        while(!set.contains(tmp)){
            set.add(tmp);
            tmp = nextInt(tmp);
            if(tmp == 1 ){
                return true;
            }
            System.out.println(tmp);
        }
        return false;
    }

    private int nextInt(int a){
        //char[] carr  = String.valueOf(a).toCharArray();
        int res = 0;

        while(a > 0 ){//important!!!   mistake
            int tmp = a % 10;
            res += tmp * tmp;
            a /= 10;
        }
        //res += a * a;
//        for(int i = 0; i < carr.length; i++){
//            res += (carr[i] - '0') * (carr[i] - '0');
//        }
        return res;
    }
}
