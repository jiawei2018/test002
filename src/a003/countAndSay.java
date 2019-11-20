package a003;

/**
 * 38. Count and Say
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221 //1 1    1 2    2 1
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 * Input Constraints:
 * <p>
 * 1 <= n <= 30
 */
public class countAndSay {

    //题意难理解,  意思是 下一个str 要读出来上一个 str ,例如 1:1   则 2: 一个'1'   就成了 2:11, 以此类推
    //理解了题意 也不算是个 easy......
    //两个解法,正算,,和recursion
    public String countAndSay(int n) {
        String res = "1";

        for (int i = 1; i < n; i++) {
            int counts = 0;//count nums of first
            StringBuilder st = new StringBuilder("");
            for (int j = 0; j < res.length(); j++) {
                counts++;
                if (j + 1 < res.length() && res.charAt(j) != res.charAt(j + 1)) {
                    st = st.append(counts).append(res.charAt(j));
                    counts = 0;
                } else if (j + 1 == res.length()) {
                    st = st.append(counts).append(res.charAt(j));//i am so stupid ....   st.append("1")????must be  counts
                }
            }
            res = st.toString();
            System.out.println(res);
        }
        return res;
    }


    public String countAndSayA(int n) {//resursion
        if (n == 1) return "1";

        String before = countAndSayA(n - 1) + " ";
        int counts = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < before.length() - 1; i++) {//mistake  must start at 0 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            if (before.charAt(i) == before.charAt(i + 1)) {
                counts++;
            } else {
                sb.append(counts).append(before.charAt(i));
                counts = 1;
            }
        }
        System.out.println(sb + " <");
        return sb.toString();
    }


//    public String countAndSayD(int n) {
//        if(n == 1){
//            return "1";
//        }
//        //递归调用，然后对字符串处理
//        String str = countAndSayD(n-1) + "*";//为了str末尾的标记，方便循环读数
//        char[] c = str.toCharArray();
//        int count = 1;
//        String s = "";
//        for(int i = 0; i < c.length - 1;i++){
//            if(c[i] == c[i+1]){
//                count++;//计数增加
//            }else{
//                s = s + count + c[i];//上面的*标记这里方便统一处理
//                count = 1;//初始化
//            }
//        }
//        System.out.println(s);
//        return s;
//    }


    //copy from web
//    public String countAndSayC(int n){
//        if(n < 1)
//            return "";
//
//        String str = "1";
//        for(int i = 1;i < n;++i){
//            int count = 0;
//            StringBuilder builder = new StringBuilder("");
//
//            for(int j = 0;j < str.length();++j){
//                ++count;
//                if((j + 1 < str.length()) && (str.charAt(j) != str.charAt(j + 1))){
//                    builder = builder.append(count).append(str.charAt(j));
//                    count = 0;
//                }else if(j + 1 == str.length()){
//                    builder = builder.append(count).append(str.charAt(j));
//                }
//            }
//            System.out.println(str);
//            str = builder.toString();
//        }
//        return str;
//    }


    public static void main(String[] args) {
        countAndSay t1 = new countAndSay();
        // t1.countAndSay(6);
        t1.countAndSayA(6);
        // t1.countAndSayD(6);
        System.out.println("=================");
        // t1.countAndSayC(6);

    }
}
