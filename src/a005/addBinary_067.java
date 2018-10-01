package a005;

/**
 * 67. Add Binary
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class addBinary_067 {

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int maxlen  = Math.max(a.length(), b.length());
        int carr = 0;

        for(int i = 0; i< maxlen; i++){
            int a1 = a.length() > i ? a.charAt(a.length() - i - 1) - '0':0;
            int b1 = b.length() > i ? b.charAt(b.length() - i - 1) - '0':0;
            res.insert(0,(a1 + b1 + carr) % 2);
            carr = a1 + b1 + carr > 1? 1:0;
        }

        if(carr == 1) res.insert(0,1);
        return res.toString();
    }

    /**  我写的这堆东西
     *  StringBuilder res = new StringBuilder();
     *         StringBuilder tmp = new StringBuilder();
     *         StringBuilder a1 = new StringBuilder();
     *         StringBuilder b1 = new StringBuilder();
     *         int curr = 0;
     *         int lena  = a.length();
     *         int lenb = b.length();
     *
     *         int gap = Math.abs(lena - lenb);
     *
     *         if(lena > lenb){
     *             while(gap > 0){
     *                 b1.append("0");
     *                 gap--;
     *             }
     *             a1 = a1.append(a);
     *             b1 = b1.append(b);
     *         }else if(lena < lenb){
     *             while(gap > 0){
     *                 a1.append("0");
     *                 gap--;
     *             }
     *             a1 = a1.append(a);
     *             b1 = b1.append(b);
     *         }else{
     *             a1 = a1.append(a);
     *             b1 = b1.append(b);
     *         }
     *
     *
     *         int len = a1.length() - 1;
     *         while(len >= 0){
     *             int d = a1.charAt(len) + b1.charAt(len) + curr;
     *             if(d > 1){
     *                 d = 0;
     *                 curr = 1;
     *             }else{
     *                 d = 1;
     *             }
     *             len --;
     *             tmp.append(d);
     *             tmp
     *         }
     *
     *         if(curr > 0){
     *             res.append(1);
     *         }
     *          res.append(tmp);
     *
     *
     *
     *         return res.toString();
     * @param args
     */





//    int maxLen = Math.max(a.length(), b.length());
//    StringBuilder sb = new StringBuilder();
//    int carry = 0;
//        for (int i = 0; i < maxLen; i++) { //从右边开始逐位取出字符串 a、b 的字符值 tempA 和 tempB，如果长度不足，则用0替代
//        int tempA = a.length() > i ? a.charAt(a.length() - i - 1) - '0' : 0;
//        int tempB = b.length() > i ? b.charAt(b.length() - i - 1) - '0' : 0;
//        sb.insert(0, (tempA + tempB + carry) % 2);  //在最左侧插入相加结果
//        carry = tempA + tempB + carry > 1 ? 1 : 0;  //得到进位
//    }
//        if (carry == 1) sb.insert(0, 1);  //如果最高位有进位，则最高位还要加一位 1
//        return sb.toString();


    public  static  void  main(String[] args){
        addBinary_067 t = new addBinary_067();

        String a = "1010", b = "1011";//"1010""1011"

        System.out.println(t.addBinary(a,b));
    }
}
