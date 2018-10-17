package a010;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Given a binary tree, return the postorder traversal of its nodes' values.

 Example:

 Input: [1,null,2,3]
 1
 \
 2
 /
 3

 Output: [3,2,1]
 Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class binaryTreePostOrderTraversal_145_hard {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
     public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer> res = new ArrayList<>();
         if (root == null) {
             return res;
         }
         LinkedList<TreeNode>  stack1 = new LinkedList<>();
         LinkedList<TreeNode>  stack2 = new LinkedList<>();

         stack1.push(root);
            while(!stack1.isEmpty()){
                TreeNode tmp = stack1.pop();
                stack2.push(tmp);

                if(tmp.left != null){
                    stack1.push(tmp.left);
                }
                if(tmp.right != null){
                    stack1.push(tmp.right);
                }
            }

            while(!stack2.isEmpty()){
                res.add(stack2.pop().val);
            }
         return res;
     }
}
