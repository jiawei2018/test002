package a007;

import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class symmetricTree {
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public boolean isSymmetric(TreeNode root) {
          if(root == null) return true;


           return isSameTree(root.left, root.right);
        }

            private boolean isSameTree(TreeNode p, TreeNode q) {
                //脑子僵化,这么简单的题没有做出来
                if(p == null && q == null) return true;
                else if(p == null || q == null) return false;
                else if(p.val == q.val){
                    //注意镜像这个概念,画图出来就更加直观
                    return isSameTree(p.left, q.right) && isSameTree(q.left, p.right);// mistake why why why???
                }
                return false;
            }

        public boolean isSymmetricA(TreeNode root) {
            if(root  == null) return true;
            Queue<TreeNode> ql = new LinkedList<>();
            Queue<TreeNode> qr = new LinkedList<>();
            ql.offer(root.left);
            qr.offer(root.right);

            while(!ql.isEmpty()){
                TreeNode left = ql.poll();
                TreeNode right = qr.poll();
                if(left == null && right == null)
                    continue;//wrong if return null   !!!!!!!!!!!!!!!!!
                else if(left == null || right == null || left.val != right.val)
                    return false;
                else
                    ql.offer(left.left);
                    ql.offer(left.right);
                    qr.offer(right.right);
                    qr.offer(right.left);
            }
            return true;
        }


    /**
     * -----------------
     */
}
