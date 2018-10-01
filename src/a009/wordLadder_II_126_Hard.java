package a009;

import java.util.*;

/**
 * 126. Word Ladder II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list.
 * Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: []
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class wordLadder_II_126_Hard {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();

        return null;
    }

    /**用来存储最终结果*/
    List<List<String>> result;

    /**用来存储某一条结果*/
    List<String> tmp;

    // from csdn
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        /**用来存储一个单词的相邻单词*/
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        /**初始化结果集*/
          result = new ArrayList<List<String>>();
          tmp = new ArrayList<String>();
        /**存储当前层的结果*/
        Set<String> current = new HashSet<String>();
        /**存储没有的遍历到的单词*/
        Set<String> unvisited = wordList;
        /**首先遍历到的便是开始的单词*/
        if (unvisited.contains(beginWord)) {
            unvisited.remove(beginWord);
        }
        /**未遍历的节点中包含结束节点*/
        unvisited.add(endWord);
        /**初始化当前层位开始节点*/
        current.add(beginWord);
        while ((!current.contains(endWord)) && unvisited.size() > 0) {
            /**初始化下一层节点*/
            Set<String> nextstep = new HashSet<String>();
            /**遍历当前层节点*/
            for (String word : current) {
                /**暴力搜索当前节点相近单词*/
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    for (int j = 0; j < 26; j++) {
                        if (ch == 'a' + j)
                            continue;
                        else {
                            char c = (char) ('a' + j);
                            String tmpword = "";
                            if (i == 0) {
                                tmpword = c + word.substring(i + 1);
                            } else {
                                tmpword = word.substring(0, i) + c + word.substring(i + 1);
                            }
                            if (unvisited.contains(tmpword)) {
                                nextstep.add(tmpword);
                                if (map.containsKey(tmpword)) {
                                    Set<String> set = map.get(tmpword);
                                    set.add(word);
                                    /**为了优化搜索，构建的是反向图*/
                                    map.put(tmpword, set);
                                } else {
                                    Set<String> set = new HashSet<String>();
                                    set.add(word);
                                    map.put(tmpword, set);
                                }// else
                            }//if
                        }//else
                    }//if
                }
            }
            /**如果没有下一层节点，直接返回*/
            if (nextstep.size() == 0) return result;
            /**找完一层，去掉该层节点。而不是每找到一个节点就去掉，避免漏掉可能的路径*/
            for (String news : nextstep) {
                unvisited.remove(news);
            }
            /**继续下一层的遍历*/
            current = nextstep;
        }
        findPath(map, endWord, beginWord);
        return result;
    }

    /**
     * 根据反向邻接表寻找遍历路径
     */
    public void findPath(Map<String, Set<String>> map, String start, String end) {

        tmp.add(start);
        if (start.equals(end)) {
            List<String> ret = new ArrayList<String>(tmp);
            Collections.reverse(ret);
            result.add(ret);
            return;
        }
        Set<String> set = map.get(start);
        for (String s : set) {
            findPath(map, s, end);
            /**递归的后续处理*/
            tmp.remove(tmp.size() - 1);
        }
    }


}
