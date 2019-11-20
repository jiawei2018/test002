package amazonOA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubtreeOfAnotherTree {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //sol1 we use serilized thought, postorder,
    //it is very slow, 18ms
    public boolean isSubtree(TreeNode s, TreeNode t) {
        set = new HashSet<>();
        String strt = recur(t);
        set.clear();
        String strs = recur(s);
        set.add(strs);
        if(set.contains(strt)){
            return true;
        }
        return false;
    }
    /*
    we could format a tree into a string
    and check all node if there is a match?
    post-order is better?
    string l = r.l
    str r = r.r
    cur = l + r ?

    */
    private String recur(TreeNode root){
        if(root == null){
            return "#";
        }
        String left = recur(root.left);
        set.add(left);
        String right = recur(root.right);
        set.add(right);
        return left + root.val +""+ right;
    }

    Set<String> set;
    //=========================================================================================


    //this is preorder good solution
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }




    //my original method bery fast 1 ms
    //we add the same size subtree == target tree size into a list then we
    //then we traverse those candidates one by one to find a match
    public boolean isSubtree________________fast(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        int k = size(t, 0, new ArrayList<>());

        List<TreeNode> candi = new ArrayList<>();
        size (s, k, candi);

        for(TreeNode n : candi) {
            if(same(n, t)) {
                return true;
            }
        }

        return false;

    }


    private int size(TreeNode root, int k, List<TreeNode> res ) {
        if (root == null) {
            return 0;
        }
        int left = size(root.left, k, res);
        int right = size(root.right, k, res);
        int cur = left + right + 1;
        if (cur == k) {
            res.add(root);
        }
        return cur;
    }

    private boolean same(TreeNode root, TreeNode target) {
        if(root == null && target == null) {
            return true;
        } else if (root == null || target == null) {
            return false;
        }
        if(root.val != target.val) {
            return false;
        }
        return same(root.left, target.left) && same(root.right, target.right);
    }


}
