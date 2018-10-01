package a001;

/**
 * 14. Longest Common Prefix
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */

 //prefix n. 前缀

//        首先一般是检查输入参数是否正确，然后是处理算法的特殊情况，之后就是实现逻辑，最后就是返回值。
//        当编程成为一种解决问题的习惯，我们就成为了一名纯粹的程序员

//知识点: string.substring(a,b) a是开头坐标,如果是0 则在第一个字符前面,意思就是substring(0,1) ,返回的是该string第一个字母
    //substring(0,5) ,返回的是该string前5个字母

public class longestCommonPrefix_014 {
    public static void main(String[] args){

    }
    private String longestCommonPrefix(String[] strs) {
        if(strs.length < 1) return "";
                String res = strs[0];
        for(int i = 1 ; i < strs.length ; i++){
            if(res.length() > strs[i].length()){
                res = res.substring(0,strs[i].length() );//mistake the 2nd parameter is legth?
            }
            for(int j  = 0; j < res.length(); j++){//mistake
                if(res.charAt(j) != strs[i].charAt(j)){
                    res = strs[i].substring(0,j);
                }
            }
        }
        return res;
    }
}



/*
private static String method(String[] strs) {
		// TODO Auto-generated method stub

		if(strs.length==0)
			return "";
		String prefix =strs[0];
		for(int i = 1;i<strs.length;i++){
			while(strs[i].indexOf(prefix) != 0){
				prefix = prefix.substring(0,prefix.length()-1);

			}
		}
		return prefix;
	}
这样耗时1ms， 这个方法效率 高,因为用了 indexof  方法
 */



/**
 indexOf() 方法有以下四种形式：
 public int indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 public int indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 int indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 */