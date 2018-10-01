package a008;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 111. Minimum Depth of Binary Tree
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 */
public class minimumDepthOfBinaryTree_111 {
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int minDepth(TreeNode root) {
      if(root == null) return 0;
      if(root.left == null && root.right == null) return 1;
      if(root.left == null) return minDepth(root.right) + 1;
      if(root.right == null) return minDepth(root.left) + 1;
      return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

        public int minDepthA(TreeNode root) {
            if(root == null) return 0;
            if(root.left == null && root.right == null) return 1;
            int depth = 1;
            Queue<TreeNode> st = new LinkedList<>();
            st.offer(root);
            int count = 0;
            while(!st.isEmpty()){
                count = st.size();
                for(int i = 0; i < count; i++){
                    TreeNode curr = st.poll();
                    if(curr.left == null && curr.right == null){
                        return depth ;
                    }else if(curr.left == null ){
                        st.offer(curr.right);
                    }else if(curr.right == null) {
                        st.offer(curr.left);
                    }else{//z这步不能少!!!!!!!否则忽略了两个都不为空这个条件
                        st.offer(curr.right);
                        st.offer(curr.left);
                    }
                }
                depth++;
            }
            return depth;
        }
}
