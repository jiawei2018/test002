package a004;

import java.util.*;

/**
 * 49. Group Anagrams
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */

public class groupAnagrams_049 {

    public List<List<String>> groupAnagrams(String[] strs) {

//        List<String> tmp = new  ArrayList<>();
//        Arrays.sort(strs);
//        String[] tmpStrs;
//        //first make it easy;
//        int idx = 0;
//
//        Map<Integer,String> dict = new HashMap<>();
//        for(int i = 0; i < strs.length; i++){
//            dict.put(i,strs[i]);
//        }
//
//        StringBuilder curr = new StringBuilder("");
//
//        for(int i = 0; i < strs.length; i++){
//            recur(strs[i], dict, tmp, curr,new boolean[strs[i].length()] );
//            res.add(tmp);
//        }
//
//        return res;
//
//    }
//
//    private void recur( String str, Map<Integer,String> dict, List<String> tmp, StringBuilder curr, boolean[] used ){
//        if(curr.length() == str.length()){
//            System.out.println(curr);
//            if(dict.containsValue(curr)){
//
//                tmp.add(curr.toString());
//               // removeIt(strs,curr);
//                return;
//            }
//        }
//        char[] c = str.toCharArray();
//        for(int i = 0; i< c.length; i++){
//            if(used[i]){
//                continue;
//            }
//            used[i] = true;
//            curr.append(c);
//            recur(str,dict,tmp,curr,used);
//            curr.deleteCharAt(curr.length() -1 );
//            used[i] = false;



        //大错特错




        List<List<String>> res = new  ArrayList<>();
        if(strs.length == 0 || strs == null) return res;
        Map<String, List<String>> dic = new HashMap<>();

        for(int i = 0 ; i < strs.length; i++){
            //String tmp = strs[i];
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String tmp = String.valueOf(c);//tostring() method will output the address of char[];

            //思路就是 找到合适的 映射关系, K--V

            if(dic.containsKey(tmp)){//key line
                dic.get(tmp).add(strs[i]);
            }else{
                List<String> cur = new ArrayList<>();
                cur.add(strs[i]);
                dic.put(tmp,cur);
            }
        }
        for(List<String> v:dic.values()){//此处的用法
            res.add(v);
        }
        return res;
    }





}
