package amazonTAG;

import java.util.*;

public class MostCommonWord819 {
    /*
    Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.


Note:

1 <= paragraph.length <= 1000.
0 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.

    * */

//总结这题很多corner case ,需要 很多clearificatio
//
// 那个判断的set可以用trie

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> fmap = new HashMap<>();
        for(String b : banned){
            set.add(b);
        }
        String p2 = paragraph.toLowerCase();//这个用法开始写错了!
        //System.out.println(p2);
        String[] p = getSarr(p2);
        //System.out.println(Arrays.toString(p));
        for(String w : p){
            if(w.length() == 0 || set.contains(w)) continue;
            fmap.put(w, fmap.getOrDefault(w, 0) + 1);
        }
        int max = -1;
        String res = "";
        for(String s : fmap.keySet()){
            int freq = fmap.get(s);
            if(freq > max){
                max = freq;
                res = s;
            }
        }
        return res;
    }

    private String[] getSarr(String str){//自己写的一个分割函数
        List<String> tmp = new ArrayList<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < str.length()){
            char c = str.charAt(i);
            if(isChar(c)){
                sb.append(c);
            } else {
                tmp.add(sb.toString());
                sb.setLength(0);
            }
            i++;
        }
        tmp.add(sb.toString());//bug here!!!!!!!!!!!!!!!!!!!最后一个一定要加进去
        //否则只有一个是不行的
        String[] res = new String[tmp.size()];
        for(i = 0; i < tmp.size(); i++){
            res[i] = tmp.get(i);
        }
        return res;
    }

    private boolean isChar(char c){
        return c >= 'a' && c <= 'z';
    }


}
