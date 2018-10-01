package a007;

/**
 * 91. Decode Ways
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class decodeWays_091 {
//此题重要,在dp题排名中 几乎频率第一
    //226
    //这个最直观,最方便
    public int numDecodingsA(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0' ) return 0;
        int len = s.length();
        int[] res = new int[len + 1];//初始化时候每个元素都是零
        res[0] = 1;
        res[1] = s.charAt(0) !=0 ? 1 : 0;

        for(int i = 2; i <= len; i++){
            int last1 = Integer.valueOf(s.substring(i -1 ,i));//最后 一个数
            int last2 = Integer.valueOf(s.substring(i -2, i));//最后两个数
            if(last1 != 0){
                res[i] += res[i -1];
            }
            if(last2 > 9 && last2 <= 26){
                res[i] += res[i -2];
            }
        }
        return res[len];
    }


    //from csdn
    public int numDecodingsB(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0' ) return 0; //注意!!!第三个边界条件
        char[] c = s.toCharArray();
        int len = c.length;
        int[]  res = new int[len + 1];//must be len +1, last idx will be res[len].....
        res[0] = 1;//because rool out  bad
        for(int i = 1; i <= len; i++){
            if(c[i - 1] != '0')
                res[i] += res[i - 1];
            if(i > 1 && c[i -2] == '1') res[i] += res[i - 2];
            if(i > 1 && c[i -2] == '2' && c[i - 1] >= '0' && c[i - 1] <= '6') res[i] += res[i - 2];
        }
        return res[len];
    }


    //from    wangzilan
    public int numDecodingsC(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0' ) return 0; //注意!!!第三个边界条件
        int cur = 1;//notice
        int pre = 1;//notice cur[ i -2];  就是cur的前一个值

        for(int i = 1; i < s.length(); i++){//not <=
            int tmp = cur;
            if(s.charAt(i) == '0' ) {
                cur = pre;//new cur = cur [ i - 2]
               // if(s.charAt(i - 1) >= '3' || s.charAt( i - 1) <= '0') return 0;// 按理说会运行更快
                 if(s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0' ) return 0;//这样写更容易理解,原来是上面那样写的
                //有任何一个地方不能翻译就失败
                //当遇到 类似 40 ,,或者 00 的 情况, 这个string就无法翻译成  全 字母的 形式
                // 如 12401 ; 12001;  无法转换
            }else{
                if(s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i - 1, i + 1)) <= 26)//此处注意,i+1  -  i-1  是切出来两个char
                 cur += pre;
                //cur = cur[i -1] + cur [i - 2];
            }
            pre = tmp;// now pre == cur [i -1]
        }
        return cur;
    }

}



/**
 public int numDecodings(String s) {

     if (s == null || s.length() == 0) return 0;
     char[] sa = s.toCharArray();
     int[] nums = new int[sa.length+1];

     nums[0] = 1;
     for(int i=1; i<=sa.length; i++) {
         if (sa[i-1] != '0') nums[i] += nums[i-1];
         if (i>1 && sa[i-2] == '1') nums[i] += nums[i-2];
         if (i>1 && sa[i-2] == '2' && sa[i-1] >= '0' && sa[i-1] <= '6') nums[i] += nums[i-2];
    }
    return nums[sa.length];
 }
*/


