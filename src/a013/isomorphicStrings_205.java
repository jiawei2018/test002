package a013;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 205.
 * Isomorphic Strings
 * Difficulty
 * Easy

 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with
 * another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */
public class isomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() < 1 || s == null){
            return true;
        }
        Map<Character, Character> map = new HashMap<>();

        char[] sarr  = s.toCharArray();
        char[] tarr = t.toCharArray();

        for(int i = 0; i < s.length(); i++){
            char s1 = sarr[i];
            char t1 = tarr[i];
            if(map.containsKey(s1)){
                //原理就是一个sr里面有 xx 的样子,那他put到map里面时候就会有
                //建一个map保存映射关系, 同时用一个set保持 被映射的char, 保证同一个char 不会被映射两次.
                char tmp = map.get(s1);
                if(tmp != t1){//表示s1有重复,而t没有
                    return false;
                }
            }else{
                if(map.containsValue(t1)){// dont have s but have t means t is repeat ,s not
                    return false;
                }
                map.put(s1, t1);
            }
        }
        return true;
    }













//    public boolean isIsomorphic(String s, String t) {
//        //why not ????????
//        if(s.length() < 1 || s == null){
//            return true;
//        }
//        if(s.length() != t.length()){
//            return false;
//        }
//        if(removeDup(s) == removeDup(t)){
//            return true;
//        }
//        return false;
//    }
//
//    private int removeDup(String str){
//        char[] carr = str.toCharArray();
//        int idx = 0;
//        for(int i = 0; i < carr.length;  i++){
//            if(i == 0 || carr[i] != carr[idx - 1]){
//               // carr[idx++] = carr[i];
//               idx++;
//            }
//        }
//        return idx;
//    }
}
