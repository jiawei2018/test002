package a010;

import java.util.*;

/**
 * 144. Binary Tree Preorder Traversal
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Given a binary tree, return the preorder traversal of its nodes' values.

 Example:

 Input: [1,null,2,3]
 1
 \
 2
 /
 3

 Output: [1,2,3]
 Follow up: Recursive solution is trivial,
 could you do it iteratively?
 */
public class binaryTreePreorderTraversal_144 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
        public List<Integer> preorderTraversal(TreeNode root) {


            List<Integer> res = new LinkedList<>();
            if(root == null) return res;
            LinkedList<TreeNode> q = new LinkedList<>();
            q.push(root);

            while(!q.isEmpty()){
                TreeNode tmp = q.pop() ;
                res.add(tmp.val);
                if(tmp.right != null) q.push(tmp.right);
                if(tmp.left != null) q.push(tmp.left);
            }
            return res;
        }











    public List<Integer> preorderTraversalr(TreeNode root) {//recursion
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

}
