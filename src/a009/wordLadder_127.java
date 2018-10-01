package a009;

import java.util.*;

/**
 * 127. Word Ladder
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class wordLadder_127 {
    public static void main(String[] args) {
        String s1 = "hot";
        String s2 = "dog";
        List<String> ss = new ArrayList<>();
        ss.add("hot");
        //ss.add("dot");
        ss.add("dog");
//        ss.add("lot");
//        ss.add("log");
//        ss.add("cog");

        wordLadder_127 t = new wordLadder_127();

        System.out.println(t.ladderLengthA(s1, s2, ss));

        //[,,,,,]
    }

    private void swapq(Queue<String> a, Queue<String> b){
        Queue<String> temp = new LinkedList<>();
        temp = a;
        a = b;
        b = temp;
    }

    private int ladderLengthA(String beginWord, String endWord, List<String> wordList) {

        //double bfs
        //but much slower,,,,,,,,why??? T_T



        if(wordList.size() == 0 ) return 0;
        HashSet<String> dict = new HashSet<>();

        dict.addAll(wordList);//this will work
        if(!dict.contains(endWord)){//check if there could be an answer;
            return 0;
        }

        Queue<String> leftq = new LinkedList<>();
        Queue<String> rightq = new LinkedList<>();

        leftq.offer(beginWord);
        rightq.offer(endWord);
        int lvl = 0;


        while(!leftq.isEmpty() && !rightq.isEmpty()){//mistake
            lvl++ ;
            if(leftq.size() > rightq.size()){
                swapq(leftq, rightq);// this would work?pass-by-value
            }

            int size = leftq.size();

            for(int i = size; i > 0; i --){
                char[] str = leftq.poll().toCharArray();

                for(int j = 0; j < str.length; j++){
                    char cc = str[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        str[j] = c;

                        if(rightq.contains(String.valueOf(str))){
                            return lvl + 1;
                        }
                        if(!dict.contains(String.valueOf(str)))
                            continue;

                        leftq.offer(String.valueOf(str));
                        dict.remove(String.valueOf(str));
                    }
                    System.out.println(String.valueOf(str));
                    str[j] = cc;//return back
                }//j
            }//i
            swapq(leftq, rightq);//mistake
        }// while
        return 0;
    }









    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        // single bfs;


        if(wordList.size() == 0 ) return 0;
        HashSet<String> dict = new HashSet<>();
        dict.addAll(wordList);//this will work

        if(!dict.contains(endWord)){//check if there could be an answer;
            return 0;
        }

        Queue<String> strq = new LinkedList<>();
        strq.offer(beginWord);
        int lvl = 0;
        while(!strq.isEmpty()){
            lvl++;
            int size = strq.size();

            for(int s = size; s > 0; s--){
                char[] str = strq.poll().toCharArray();
                for(int i = 0; i < str.length; i++){
                    char cur = str[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        str[i] = c;

                        if(String.valueOf(str).equals(endWord))
                            return lvl + 1;//watch this line !!!! must +1
                        if(!dict.contains(String.valueOf(str))){
                            continue;
                        }
                        strq.offer(String.valueOf(str));
                        dict.remove(String.valueOf(str));
                    }
                    str[i] = cur;
                }
            }

        }
        return 0;
    }
}
