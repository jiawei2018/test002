package a008;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 104. Maximum Depth of Binary Tree
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class maxiumDepthOfBinayTree {
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public int maxDepth(TreeNode root) {
            int res = 0;
            if(root == null) return res;
            TreeNode node ;
            Queue<TreeNode> q = new LinkedList<>() ;
            int count = 0;//记录当前层的node的数量,
            int depth = 0;
            q.offer(root);
            while(!q.isEmpty()){
                node = q.poll();
                count--;
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                if(count == 0){
                    count = q.size(); //想想为什么 必须在这里面?
                    //显然,只有层计数为零了,才表示清空一层,深度可以向下发展
                    depth++;
                }
            }
            return depth;
        }

    private int maxDepthB(TreeNode root) {//ac,but stupid
        if(root == null) return 0;
        return  Math.max( 1 + maxDepthB(root.left), 1 + maxDepthB(root.right));
    }

    private int maxDepthA(TreeNode root) {//ac,but stupid
        int res = 0;
        if(root == null) return res;
        res = getdepth(root, 0);
        return res;
    }

    private int getdepth(TreeNode node, int depth){
       if(node == null) return depth;
           return (Math.max(getdepth(node.left, depth+1), getdepth(node.right, depth+1)));
    }


}
