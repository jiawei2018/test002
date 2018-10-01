package a004;

/**
 * 50. Pow(x, n)
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */

public class POW_x_n_050 {

    public double myPow(double x, int n) {

        //关键是1递归的二分法,
        if (n == 0) return 1;//这就是base case  惊人额简单才是正道理!!!!!!!!!!!!!!!
        //if (n == 1) return x; //这句是废话, 又一次 说明 我的递归理解还差的远

        double tmp = myPow(x, (n / 2));//必须这样写,否则会递归两次

        if (n % 2 == 0) {
            return tmp * tmp;
        } else if (n > 0) {
            return tmp * tmp * x;
        } else { //if(n < 0)
            return tmp * tmp *(1 / x);//这句需要解释  tmp * tmp * 1/x ??
            //递归最终会干到0, 所以 返回了1
            // 此题的关键一个是  tmp = myPow(x, (n / 2))  另一个就是 负指数的处理
            //还应该注意到intde max_value 比min_value 绝对值要小1  !!!!
        }
    }



    //这个更加直观
    public double myPowD(double x, int n) {
        double y=x;
        if(n==0){
            return 1;
        }else{
            if(n==Integer.MIN_VALUE){
                n=n+2;//very compexicity corner case
            }
            int abs=Math.abs(n);
            double temp=myPow(y,abs/2);
            if(abs%2==0){
                y=temp*temp;
            }else{
                y*=(temp*temp);
            }
            return n < 0 ? Math.max(1/y, 0.0):y;
        }
    }


    //method from basket wang

    private double mypowc(double x, int n){
        if(n == 0 || x == 1 ) return 1;
        if(n == 1) return x;

        if(n < 0) return 1/(x * mypowc(x,-(n + 1)));

        double res = 1;
        while(n > 1){
            if(n % 2 == 1) res = res * x;//先 乘 一个1剩下的就是1偶数了.
            x = x * x;
            n = n / 2;
        }
        res = res * x;
        return res;
    }




        public double myPowB(double x, int n) {
            int sign=1;
            if(n<0){
                sign=-1;
                n=-n;
            }
            return sign<0? 1/pow(x,n) : pow(x,n) ;
        }


        public double pow(double x,int n){
            if(n==0) return 1;
            if(n==1) return x;
            if(n%2==0) {
                double tmp=pow(x,n/2);
                return tmp*tmp;
            }else{
                double tmp=pow(x,n/2);
                return tmp*tmp*x;
            }
        }




    public int maxSubArrayC(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int segmentSum = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            segmentSum = Math.max(nums[i], segmentSum + nums[i]);
            res = Math.max(res, segmentSum);
        }
        return res;
    }








    public static void main(String[] args){
        double i = 2.0;
        int j = -4;
        POW_x_n_050 t = new POW_x_n_050();

        System.out.println(t.myPow(i,j));

    }
}
