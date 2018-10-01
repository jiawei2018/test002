package a008;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */

public class binaryTreeLevelOrderTraversal_II_107_easy {
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res= new LinkedList<>();
            if(root == null) return res;
            Queue<TreeNode> qnode = new LinkedList<>();
            Stack<List<Integer>>  st = new Stack<>();
            int count = 0;
            qnode.offer(root);
            while(!qnode.isEmpty() ){
                count = qnode.size();
                List<Integer> temp  = new ArrayList<>();
                for(int i = 0; i < count; i++){//此处的办法有没有想出来,关键这个题是null的处理
                    TreeNode curr = qnode.poll();
                    if(curr.left != null) qnode.offer(curr.left);
                    if( curr.right != null) qnode.offer(curr.right);
                    temp.add(curr.val);
                }
               ((LinkedList<List<Integer>>) res).addFirst(temp);
            }
            return res;
        }



}
