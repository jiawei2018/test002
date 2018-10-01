package a008;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class binaryTreeZigzagLevelOrderTraversal_103 {
      class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null)return res;
            int lvlsize = 0;
            int dir = 1;
            Queue<TreeNode> q = new LinkedList<>();
            //Stack<TreeNode>  s = new Stack<>();
            q.offer(root);
            //So poll() returns null if the list is empty, and pop() (and removeFirst()) raises a NoSuchElementException.
            // This makes pop() a slightly nicer method to use, since you don't have to deal with nulls.

            //一次通过,但是之前的东西的还是记得不清楚
            while(!q.isEmpty()){
                lvlsize = q.size();
                List<TreeNode>  lvl = new ArrayList<>();
                List<Integer> temp = new LinkedList<>();
                for(int i = 0; i < lvlsize; i++){
                    TreeNode node = q.poll();//这三句没记清楚, 唉
                    lvl.add(node);
                    if(node.left != null) q.offer(node.left);//这三句没记清楚, 唉
                    if(node.right != null) q.offer(node.right);//这三句没记清楚, 唉
                }
                int j = lvlsize - 1;
                for(int i = 0; i < lvlsize; i++){
                    if(dir > 0){
                        temp.add(lvl.get(i).val);
                    }else{
                        ((LinkedList<Integer>) temp).addFirst(lvl.get(i).val);
                    }
                }
                res.add(temp);
                dir = -dir;
            }
            return res;
        }


    public List<List<Integer>> zigzagLevelOrderA(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ziglvl(res, 0, root, 1);
        return res;

    }

    private void ziglvl(List<List<Integer>> res, int lvl, TreeNode node, int dir){
        if(node == null) return;

        if(res.size() <= lvl){
            res.add(new LinkedList<>());//注意此处!!
        }

        if(dir > 0){
            res.get(lvl).add(node.val);
        }else{
            ((LinkedList<Integer>)res.get(lvl)).addFirst(node.val);//这个转换真风骚.......
        }
        ziglvl(res, lvl + 1, node.left, -dir);
        ziglvl(res, lvl + 1, node.right, -dir);
    }


}
