package a008;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class binaryTreeLevelOrderTraversal_102 {
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while(!q.isEmpty()){
                int lvlsize = q.size();
                List<Integer> tmp = new ArrayList<>();
                for(int i = 0; i < lvlsize; i++){
                    TreeNode  node = q.poll();
                    tmp.add(node.val);
                    if(node.left != null) q.offer(node.left);
                    if(node.right != null) q.offer(node.right);
                }
                res.add(tmp);
            }
            return res;
        }

    public List<List<Integer>> levelOrderA(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        lvlorer(res, 0, root);
        return res;
    }

    private void lvlorer(List<List<Integer>> res, int lvl, TreeNode node){
       if(node == null ) return;

       if(res.size() <= lvl){
           res.add(new ArrayList<>());
       }
       res.get(lvl).add(node.val);

         lvlorer(res, lvl + 1, node.left);
         lvlorer(res, lvl + 1, node.right);
    }
}
