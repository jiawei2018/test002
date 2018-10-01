package a003;

/**
 * 29. Divide Two Integers
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 231 − 1 when the division result overflows.
 */

public class divideTwoIntegers_029 {

    //目的：计算出被除数里面包含了多少个除数(如果不停地减去除数并计算个数可以实现，但是效率太低)
    //
    //改进：通过位移来计算个数
    //
    //原理：将除数左移1位就是乘以2，一直将除数左移到大于被除数，
    // 同时tmpsum也要左移相同的次数(被除数里包含多少个除数)，每次执行后减去改变后的除数，再重复执行。

    public int divide(int dividend, int divisor) {
        //try first at ++  超时.....,必须的,哈哈
        if(dividend == 0 ) return 0;
        int dids = dividend > 0 ? 1:-1;
        int dirs = divisor > 0 ? 1:-1;
        long res = 0l;
        long unsdid = Math.abs((long)dividend);
        long unsdis = Math.abs((long)divisor);
        long tmpdis = unsdis;
        long tmpsum;
       while(unsdid >= unsdis ){
            tmpsum = 1l;//这句还原很重要!!!
            tmpdis = unsdis;//这句还原很重要!!!
            while(unsdid > (tmpdis<<1)){ //关键还是二进制操作,这个点还是不熟悉啊.
                tmpdis = tmpdis<<1;
                tmpsum = tmpsum<<1;
            }

            unsdid -= tmpdis;
            res += tmpsum;
        }

        if(dids + dirs == 0){
            if(-res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return  (int)-res;
        }

        if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }

    public static void main(String[] args){
        //-2147483648
        //-1
        int a = -2147483648;
        int b = -1;
        divideTwoIntegers_029 t = new divideTwoIntegers_029();

        System.out.println(t.divide(a,b));



    }

}
