package a005;

/**
 * 70. Climbing Stairs
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class climeStairs {

    public int climbStairs(int n) {
        //dp  always difficult


        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2)return 2;

        int[] curr = new int[n];
        int one = 1;
        int two = 2;
        int temp = 0;

        for(int i = 3; i <= n; i++){
            temp = one  + two;
            one  = two;
            two  = temp;
        }

        return temp;
    }

    public static void main(String[] args){
        climeStairs t = new climeStairs();
        System.out.println(t.climbStairs(3));
    }
}
