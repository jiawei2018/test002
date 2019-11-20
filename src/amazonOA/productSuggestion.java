package amazonOA;

import java.util.*;

public class productSuggestion {
//    Amazon | OA 2019 | Product Suggestions
//10
//    Sithis's avatar
//    Sithis
//            Moderator
//5987
//    Last Edit: November 2, 2019 6:34 PM
//
//9.1K VIEWS
//
//    Description:
//    Implement a function to return product suggestions using products from a product repository after each character is typed by the customer in the search bar.
//    If there are more than THREE acceptable products, return the product name that is first in the alphabetical order.
//    Only return product suggestions after the customer has entered two characters.
//    Product suggestions must start with the characters already typed.
//    Both the repository and the customer query should be compared in a CASE-INSENSITIVE way.
//
//    Input:
//    The input to the method/function consist of three arguments:
//
//    numProducts, an integer representing the number of various products in Amazon's product repository;
//    repository, a list of unique strings representing the various products in Amazon's product repository;
//    customerQuery, a string representing the full search query of the customer.
//    Output:
//    Return a list of a list of strings, where each list represents the product suggestions made by the system as the customer types each character of the customerQuery. Assume the customer types characters in order without deleting/removing any characters.
//
//            Example:
//    Input:
//    numProducts = 5
//    repository = ["mobile", "mouse", "moneypot", "monitor", "mousepad"]
//    customerQuery = "mouse"
//
//    Output:
//            [["mobile", "moneypot", "monitor"],
//            ["mouse", "mousepad"],
//            ["mouse", "mousepad"],
//            ["mouse", "mousepad"]]
//
//    Explanation:
//    The chain of words that will generate in the search box will be mo, mou, mous and mouse, and each
//    line from output shows the suggestions of "mo", "mou", "mous" and "mouse", respectively in each line.
//    For the suggestions that are generated for "mo", the matches that will be generated are:
//            ["mobile", "mouse", "moneypot", "monitor", "mousepad"]. Alphabetically, they will be reordered to
//["mobile", "moneypot", "monitor", "mouse", "mousepad"]. Thus, the suggestions are ["mobile", "moneypot", "monitor"]
//
//    Related problems:
//
//    https://leetcode.com/problems/design-search-autocomplete-system/
//    online assessment
//    trie
//            amazon
//    Comments: 13
//    BestMost VotesNewest to OldestOldest to Newest
//    Type comment here... (Markdown is supported)
//
//    Preview
//
//            Post
//    davidsoon's avatar
//    davidsoon
//62
//    November 6, 2019 5:02 PM


    private TrieNode root;

    public List<String> productSuggestions(String[] repo, String query) {
        root = new TrieNode();

        for (String str : repo) {
            add(str);
        }
        int len = query.length();
        // mouse
        for (int i = len - 3; i <= len; i++) {
            search(query.substring(0, i));
        }

        return null;
    }

    private void add(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            TrieNode next = cur.children.get(c);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            next.queue.offer(s);
            if (next.queue.size() > 3) {
                next.queue.poll();
            }
            cur = next;

        }
    }

    private List<String> search(String input) {
        List<String> res = new ArrayList<>();
        TrieNode p = root;
        for (char c : input.toCharArray()) {
            TrieNode child = p.children.get(c);
            if (child == null) { // if not found, return an empty
                return new ArrayList<>();
            }
            p = child;
        }
        PriorityQueue<String> pq = new PriorityQueue<>(p.queue);
        int cnt = 0;
        while (!pq.isEmpty() && cnt < 3) {
            res.add(0, pq.poll());
        }
        System.out.println(res.toString());
        return res;

    }

    public class TrieNode {
        Map<Character, TrieNode> children;
        Queue<String> queue;
        public TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
            this.queue = new PriorityQueue<>((a, b) -> b.toLowerCase().compareTo(a.toLowerCase()));
        }
    }
}
