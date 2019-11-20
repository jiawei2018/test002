package a014;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 222.
 * Count Complete Tree Nodes
 * Difficulty
 * Medium
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 */
public class countCompleteTreeNodes_222 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
        //recursion ....
//        public int countNodes(TreeNode root) {
//                //TLE
//            if(root == null){
//                return 0;
//            }
//
//            return countNodes(root.left) + countNodes(root.right) + 1;
//        }

    //iteriter will also TLE i guess....

    //also TLE...
//        public int countNodes(TreeNode root) {
//            if(root == null){
//                return 0;
//            }
//             int count = 1;
//
//            Deque<TreeNode> q = new ArrayDeque<>();
//            q.offer(root);
//
//            while(!q.isEmpty()){
//                int size = q.size();
//
//                for(int i = 0; i < size; i++){
//                    TreeNode tmp = q.poll();
//                    count++;
//                    if(tmp.left != null){
//                        q.offer(tmp.left);
//                    }
//                    if(tmp.right != null){
//                        q.offer(tmp.right);
//                    }
//                }
//            }
//            return count;
//        }

    public static void main(String[] args) {
        System.out.println(1 << 3);
    }

    public int countNodes(TreeNode root) {
        int height = getHeight(root);
        if(height == 0){
            return 0;
        }
        int count = 0;//need check

        while(root != null){
            //System.out.println(height);
            if(getHeight(root.right) ==  height - 1){//means the gap in the right tree
                //so left is perfect tree
                //add left node count
                count = count + (int)Math.pow(2, height - 1);//此处是左子树的个数+1,所以是
                // 满二叉树个数是 2^树高 - 1; 所以 加上 根的 1 就是
                //((int)Math.pow(2, height - 1) -1  )  + 1
                root = root.right;
            }else{//gap in the left tree
                //so the right tree is perfect tree
                count = count + (int)Math.pow(2, height - 2) ;
                root = root.left;
            }
            height--;//important , go to the next level
        }
        return count;
    }

    private int getHeight(TreeNode root){
        //only work for complete binary tree!!!
        if(root == null){
            return 0;
        }
        return getHeight(root.left) + 1;
    }



}
