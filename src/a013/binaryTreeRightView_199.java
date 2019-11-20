package a013;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199.
 * Binary Tree Right Side View
 * Difficulty
 * Medium

 * Submissions
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class binaryTreeRightView_199 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            //level order traversal.....
            if(root == null){
                return res;
            }
            int size = 0;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while(!q.isEmpty()){
                size = q.size();
                for(int i = 0; i < size; i++){
                    TreeNode tmp = q.poll();
                    if(tmp.left != null){
                        q.offer(tmp.left);
                    }
                    if(tmp.right != null){
                        q.offer(tmp.right);
                    }
                    if(i == size - 1){
                        res.add(tmp.val);
                    }
                }
            }
            return res;
        }


        //recursion not easy to understand
    //思路
        //DFS
        //每当recursion一进入到next level，
        //就立马加上该level的right side node到result里
        //对应的，
        //在recursion的时候，先处理 root.right
        public List<Integer> rightSideViewA(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            //level order traversal.....
            if(root == null){
                return res;
            }
            recur(root,0,res);
            return res;
        }

        private void recur(TreeNode root, int level, List<Integer> res){
            if(root == null){
                return;
            }
            if(res.size() == level){//this is key!!
                res.add(root.val);
            }
            recur(root.right, level + 1, res);//this is key !!
            recur(root.left, level + 1, res);
        }



}
