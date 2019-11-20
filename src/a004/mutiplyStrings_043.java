package a004;

/**
 * 43. Multiply Strings
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class mutiplyStrings_043 {
//    The length of both num1 and num2 is < 110.
//            * Both num1 and num2 contain only digits 0-9.
//            * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
// * You must not use any built-in BigInteger library or convert the inputs to integer directly.

    private String multiply(String num1, String num2) {
        //遇到这种题 要画图来辅助思路!!!!!!!!
        //https://www.youtube.com/watch?v=Z_xGMYUSEJ8
        if(num1 == null || num2 == null ){
            return "0";//leetcode 这句没作用
        }

        int[] res = new int[num1.length() + num2.length()];

        for(int i = num1.length() -1 ; i >= 0; i--){
            for(int j = num2.length() -1 ; j >= 0; j--){
                int mul = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                int lowpos = i + j + 2 - 1; //because res.length = num1.length() + num2.length();题点
                //last el is res.l -1 ;
                //and i = n1.length -1, j = n2.length -1 ; so  res.l - 1  = i + j +2 -1;
                int highpos = i + j;//high is at he left of low ,so is low --;
                mul += res[lowpos];//实际结果是之前的进位到lowpos以后的那个 进位 与当前乘积的和. res[low] 其实就是进位
                res[lowpos] = mul % 10; //个位 是模一下//题点
                res[highpos] += mul / 10;//十位是除一下//题点
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int d : res){
            if(d == 0 && ans.length() == 0 ) continue;//此句精妙!  一定要记住 这个 leadingzero的去除方法!!
            ans.append(d);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }

    //////////////////////////////////////////////////////////////////////////////////
    private String multiplyA(String num1, String num2) {
        if(num1.equals("0")  || num2.equals("0") || num1.length() == 0 || num2.length() == 0) return "0";//此处必须用.equals方法,直接的== 不行!!!!
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length() -1 ; i >= 0; i--){
            for(int j = num2.length() -1 ; j >= 0; j--){
                int mul = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                int lowpos = i + j + 1; //because res.length = num1.length() + num2.length();题点
                int highpos = i + j;//high is at he left of low ,so is low --;
                int sum = mul + res[lowpos];//当前积的结果
                res[lowpos] = sum % 10; //个位 是模一下//题点
                res[highpos] = res[highpos] + sum / 10;//十位是除一下//题点
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int d : res){
            if(d == 0 && ans.length() == 0 ) continue;//此句精妙!  一定要记住 这个 leadingzero的去除方法!!
            ans.append(d);
        }
        return ans.toString();
    }



//    private StringBuilder helper(String num, int c,int asc, StringBuilder curans){//one digi multi digig like 2 * 88997
//        int tmp = num.charAt(num.length() - 1 ) - '0';
//        //int tmp1 = c - '0';
//        int res = tmp * c + asc;
//        if(res > 10 ){
//            asc = res / 10;
//        }
//        res = res - asc*10;
//        curans.append(res);
//        //num = num.substring(0, num.length() -1 );
//        helper (num.substring(0,num.length()-1), c, asc, curans) ;
//       // helper(num.substring(0,num.length()-1),c);
//        return curans;
//    }

    public static void main(String[] args){
        mutiplyStrings_043 t1 = new mutiplyStrings_043();
        String a = "0";
        String b = "0";
        System.out.println(t1.multiply(a,b) + " <<__043");
    }
}
