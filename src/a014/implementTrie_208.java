package a014;

import java.util.*;

/**
 * 208.
 * Implement Trie (Prefix Tree)
 * Difficulty
 * Medium
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 * <p>
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class implementTrie_208 {
    //重点题
    class Trie {
        // work but very slow....... 6.8%
        Set<String> set = new HashSet<>();
        Set<String> prifixSet = new HashSet<>();

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            set.add(word);
            genPrefix(word);
        }

        //are consist of lowercase letters a-z. use this one to
        private void genPrefix(String word) {
            if (word.length() == 0 || word == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {//no need full legth
                sb.append(word.charAt(i));
                prifixSet.add(sb.toString());
            }
        }


        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (set.add(word)) {
                set.remove(word);
                return false;
            } else {
                return true;
            }
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prifixSet.add(prefix)) {
                prifixSet.remove(prefix);
                return false;
            } else {
                return true;
            }
        }
    }


    /*
     * 字典树，这个需要好好学习
     * http://blog.csdn.net/xudli/article/details/45598337
     * 记着吧
     * */
    class TrieNode {
        char c;
        boolean isLeaf = false;
        Map<Character, TrieNode> childred = new HashMap<Character, TrieNode>();

        public TrieNode(char d) {
            c = d;
        }

        public TrieNode() {
        }
    }

    class TrieA {
        TrieNode root = null;

        /**
         * Initialize your data structure here.
         */
        public TrieA() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Map<Character, TrieNode> childred = root.childred;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode one = null;
                if (childred.containsKey(c))
                    one = childred.get(c);
                else {
                    one = new TrieNode(c);
                    childred.put(c, one);
                }
                childred = one.childred;
                if (i == word.length() - 1)
                    one.isLeaf = true;
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode res = searchNode(word);
            if (res != null && res.isLeaf)
                return true;
            else
                return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode res = searchNode(prefix);
            if (res != null)
                return true;
            else
                return false;
        }


        private TrieNode searchNode(String word) {
            TrieNode res = null;
            Map<Character, TrieNode> childred = root.childred;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (childred.containsKey(c) == false)
                    return null;
                else {
                    res = childred.get(c);
                    childred = res.childred;
                }
            }
            return res;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
