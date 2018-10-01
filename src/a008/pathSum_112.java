package a008;

import java.util.Stack;

/**
 * 112. Path Sum
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class pathSum_112 {
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
        public boolean hasPathSum(TreeNode root, int sum) {

              if(root == null) return false;//这句不能少!!
              if(root.left == null && root.right == null) return root.val == sum;

              //下面两句就是废话......上面两个条件已经足够删除这两句的意思
            //else if(root.left  != null && root.right == null) return hasPathSum(root.left , sum - root.val);
           // else if(root.right != null && root.left ==  null) return hasPathSum(root.right,sum - root.val);
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum- root.val);
        }

    public boolean hasPathSumB(TreeNode root, int sum) {

        if(root == null) return false;//这句不能少!!
        if(root.left == null && root.right == null) return root.val == sum;
        Stack<TreeNode> stnode = new Stack<>();
        Stack<Integer> stsum = new Stack<>();
        stnode.push(root);
        stsum.push(sum);

        while(!stnode.isEmpty()){
            TreeNode temp = stnode.pop();
            int thisum = stsum.pop();
            if(temp.left == null && temp.right == null ){
                if(temp.val == thisum) return true;
            }

               // return temp.val == thisum;//绝对不能这样写!!否则只判断一次就退出函数了,  太纯了,这不是第一次犯这个错误了!!!
            ///吸取教训,每次要看这里!!!!!!!
            if(temp.left != null){
                stnode.push(temp.left);
                stsum.push(thisum - temp.val);
            }
            if(temp.right != null){
                stnode.push(temp.right);
                stsum.push(thisum - temp.val);
            }
        }
        return false;
      //  return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum- root.val);
    }
}
