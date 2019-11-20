package a014;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 211.
 * Add and Search Word - Data structure design
 * Difficulty
 * Medium
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing
 * only letters a-z or .. A . means it can represent any one letter.
 * <p>
 * Example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class addAndSearchWord_211 {

    public static void main(String[] args) {
        //addAndSearchWord_211 t = new addAndSearchWord_211();
        WordDictionary t;
        t = new WordDictionary();
        t.addWord("bad");
        t.addWord("dad");
        t.addWord("mad");
        t.search("sad");
        t.search(".ad");


    }

    //重点题
//    static class TrieNode {//
//        Map<Character, TrieNode> children;
//        boolean isWord;
//
//        public TrieNode() {
//            children = new HashMap<>();
//            isWord = false;
//        }
//
//        @Override
//        public String toString() {
//            return isWord + String.valueOf(children.size());
//        }
//    }


   // static class WordDictionary {
//        private TrieNode root;
//
//        /**
//         * Initialize your data structure here.
//         */
//        public WordDictionary() {
//            root = new TrieNode();
//        }
//
//        /**
//         * Adds a word into the data structure.
//         */
//        public void addWord(String word) {
//            TrieNode node = root;
//
//            for (int i = 0; i < word.length(); i++) {
//                char c = word.charAt(i);
//                if (!node.children.containsKey(c)) {
//                    TrieNode tmp = new TrieNode();
//                    node.children.put(c, tmp);
//                }
//                node = node.children.get(c);
//            }
//            node.isWord = true;
//



//            Map<Character, TrieNode> children = root.children;
//            for (int i = 0; i < word.length(); i++) {
//                char c = word.charAt(i);
//                TrieNode tmp;
//                if (!children.containsKey(c)) {
//                    tmp = new TrieNode();
//                    children.put(c ,tmp);
//                } else {
//                    tmp = children.get(c);
//                }
//                children = tmp.children;
//                if(i == word.length() - 1){
//                    tmp.isWord = true;
//                }
//            }
        }


        /**
         * Returns if the word is in the data structure.
         * A word could contain the dot character '.' to represent any one letter.
         */
//        public boolean search(String word) {
//            return searchNode(word, root);
//        }
//
//
//        private boolean searchNode(String word, TrieNode node) {
//            //base case
//            if (node == null) return false;
//            if (word.length() == 0) return node.isWord;
//
//            Map<Character, TrieNode> children = node.children;
//
//            char c = word.charAt(0);
//            if (c == '.') {
//                for (char key : children.keySet()) {
//                    if (searchNode(word.substring(1), children.get(key))) {
//                        return true;
//                    }
//                }
//                return false;
//            } else if (!children.containsKey(c)) {
//                return false;
//            } else {// c in [a ...z];
//                TrieNode t = children.get(c);
//                return searchNode(word.substring(1), t);
//            }
//        }


   // }






    class TrieNode{
       TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
        @Override
        public String toString(){
            return String.valueOf(isWord) + " <si";
        }
    }


    class WordDictionary {

        private TrieNode root;
        //work 's
        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode node = root;

            for(int i = 0; i < word.length(); i++){
                int  idx = word.charAt(i) - 'a';
                if(node.children[idx] == null){
                    TrieNode tmp = new TrieNode();
                    node.children[idx] = tmp;
                }
                node = node.children[idx];
            }
            node.isWord = true;
        }


        /**
         * Returns if the word is in the data structure.
         * A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return searchNode(word, root);
        }


        private boolean searchNode(String word, TrieNode node) {
            //base case
            if (node == null) return false;
            if (word.length() == 0) return node.isWord;

            TrieNode[] children = node.children;

            char c = word.charAt(0);
            if (c == '.') {
                for(int i = 0; i < 26; i++){
                    if(children[i] != null){
                        //three way to substring
                        //must know
                        if(searchNode(word.substring(1), children[i])){
                            return true;
                        }
                    }
                }
                return false;
            } else if (children[c - 'a'] == null) {
                return false;
            } else {// c in [a ...z]; and trienode is not null;
                TrieNode  t = children[c - 'a'];
                return searchNode(word.substring(1), t);
            }
        }













/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}

/**
 * class WordDictionary {
 * private TrieNode root = new TrieNode();
 * <p>
 * public void addWord(String word) {
 * Map<Character, TrieNode> children = root.children;
 * for(int i=0; i<word.length(); i++) {
 * char c = word.charAt(i);
 * TrieNode t;
 * if(children.containsKey(c)) {
 * t = children.get(c);
 * } else {
 * t = new TrieNode(c);
 * children.put(c, t);
 * }
 * children = t.children;
 * if(i==word.length()-1) t.leaf=true;
 * }
 * }
 * <p>
 * public boolean search(String word) {
 * return searchNode(word, root);
 * }
 * <p>
 * public boolean searchNode(String word, TrieNode root) {
 * if(root==null) return false;
 * if(word.length() == 0 ) return root.leaf;
 * <p>
 * Map<Character, TrieNode> children = root.children;
 * TrieNode t = null;
 * char c = word.charAt(0);
 * if(c=='.') {
 * for(char key : children.keySet() ) {
 * if(searchNode(word.substring(1), children.get(key) )) return true;
 * }
 * return false;
 * } else if(!children.containsKey(c)) {
 * return false;
 * } else {
 * t = children.get(c);
 * return searchNode(word.substring(1), t);
 * }
 * }
 * }
 * <p>
 * class TrieNode {
 * <p>
 * char c;
 * boolean leaf;
 * HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
 * <p>
 * public TrieNode(char c) {
 * this.c = c;
 * }
 * <p>
 * public TrieNode(){};
 * }
 */
