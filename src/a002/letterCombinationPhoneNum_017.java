package a002;
/*
        17. Letter Combinations of a Phone Number
        DescriptionHintsSubmissionsDiscussSolution
        Pick One
        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

        A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
   2 abc
   3 def
   4 ghi
   5 jkl
   6 mno
   7 pqrs
   8 tuv
   9 wxyz


        Example:

        Input: "23"
        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
        Note:

        Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
//dfs和bfs需要系统的学一遍
//目前有点浪费时间了,看YouTube
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinationPhoneNum_017 {

    public List<String> letterCombinations(String digits) {
        //char[] nums ={2,3,4,5,6,7,8,9};
        //String[] letter = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
    if(digits == null || digits.length() ==0){
        return res;
    }

        Map<Integer,String> dict = newDic();
        StringBuilder str1 = new StringBuilder();
        helper(digits,0,dict,str1,res);
        return res;
    }


   private void  helper(String digits, int index , Map<Integer,String>  diction, StringBuilder sb , List<String> result) {
       //几个参数
       /*
       String digits, 输入
       int index , 当前深度
       Map<Character,String> diction,反应字母和数字对应关系的 map
       StringBuilder sb ,
       List<String> result, 结果
        */
       //base case用来停止recursion
       if (index == digits.length()) {
           result.add(sb.toString());
           return;
       }
       //recursion rule  此处开始recursion  的两部分
       int c = digits.charAt(index) - '0';//get the current number , like 234   , ->2
       String str = diction.get(c);//turn into 2->abc;

       for (char cc : str.toCharArray()) {
           sb.append(cc);
           //recursion
           helper(digits, index + 1, diction, sb, result);
           //出来之后 就删除已经用过的字母
           sb.deleteCharAt(sb.length() - 1);//删除sb的最后一个字母
       }

   }


       private Map<Integer,String>  newDic(){
           Map<Integer,String> dicts = new HashMap<>();
           dicts.put(1,"");
           dicts.put(2,"abc");
           dicts.put(3,"def");
           dicts.put(4,"ghi");
           dicts.put(5,"jkl");
           dicts.put(6,"mno");
           dicts.put(7,"pqrs");
           dicts.put(8,"tuv");
           dicts.put(9,"wxyz");
           return dicts;
       }

    public static void main(String[] args){
        letterCombinationPhoneNum_017 t = new letterCombinationPhoneNum_017();

        System.out.println(t.letterCombinations("23"));




    }
}



/*
 2     public List<String> letterCombinations(String digits) {
 3         //把table上的数字对应的字母列出来，当输入为2是，digits[2]就是2所对应的"abc"
 4         String[] table = new String[]
 5                              {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
 6         List<String> list = new ArrayList<String>();
 7         //index从0开始，即digits的第一个数字
 8         letterCombinations(list,digits,"",0,table);
 9         return list;
10     }
11
12     private void letterCombinations (List<String> list, String digits,
13                                     String curr, int index,String[] table) {
14         //最后一层退出条件
15         if (index == digits.length()) {
16             if(curr.length() != 0) list.add(curr);
17             return;
18         }
19
20         //找到数字对应的字符串
21         String temp = table[digits.charAt(index) - '0'];
22         for (int i = 0; i < temp.length(); i++) {
23             //每次循环把不同字符串加到当前curr之后
24             String next = curr + temp.charAt(i);
25             //进入下一层
26             letterCombinations(list,digits,next,index+1,table);
27         }
28     }
 */



/*用非递归 ,也是个重要解法
String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
 public List<String> letterCombinations2(String digits) {
        LinkedList<String> l = new LinkedList<String>();
        if(digits.length()==0){
            return l;
        }
        l.add("");

        int empty = 0;
        for(int i = 0 ; i < digits.length() ; i++){
            int number = digits.charAt(i) - '0';

            String letter = letters[number];
            if(letter.length() == 0){
                empty++;
                continue;
            }
            while(l.peek().length() + empty == i){
                String peek = l.removeFirst();
                for(int j = 0 ; j<letter.length() ; j++){
                    l.add(peek+letter.charAt(j));
                }
            }
        }
        return l;
    }

 */
