package googleOA;

public class oa18maxDistance {

    public static void main(String[] args) {
        oa18maxDistance t = new oa18maxDistance();
        String[] strs = {"1011100", "1011011","1001111"};
        String[] strs1 = {"1011000","1011110"};
        System.out.println(t.getMaxDistance(strs1));
    }


    //The distance between 2 binary strings is the sum of their lengths after removing the common prefix.
    // For example: the common prefix of 1011000 and 1011110 is 1011 so the distance is len("000") + len("110") = 3 + 3 = 6.
    //
    //Given a list of binary strings, pick a pair that gives you maximum distance among all possible pair and return that distance.
    public int getMaxDistance(String[] strs){
        //strs : "1001010"...
        if(strs == null || strs.length == 0){
            return 0;
        }
        root = new Trie();
        for(String str : strs){
            buildTrie(str);
        }
        maxSum = 0;
        getMaxHeight(root);
        return maxSum;
    }
    Trie root;//this trie is a binary tree
    int maxSum;
    private int getMaxHeight(Trie root){
        if(root == null){
            return 0;
        }
        int left = getMaxHeight(root.left);
        int right = getMaxHeight(root.right);
        if(left > 0 && right > 0){//here !!!!! BUG
            maxSum = Math.max(maxSum, left + right);
        }

        return Math.max(left, right) + 1;
    }

    private void buildTrie(String str){
        Trie cur = root;
        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - '0';
            //System.out.println(idx +"  <<adf");
            if(idx == 0){
                if(cur.left == null){
                    cur.left = new Trie();
                }
                cur = cur.left;
            } else {
                if(cur.right == null){
                    cur.right = new Trie();
                }
                cur = cur.right;
            }
        }
    }



    class Trie{
        //int val;
        boolean isEnd;
        Trie left;//0
        Trie right;
    }
}
