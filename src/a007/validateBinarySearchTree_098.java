package a007;

/**
 * 98. Validate Binary Search Tree
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 */
public class validateBinarySearchTree_098 {
     class TreeNode {
       int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public boolean isValidBST(TreeNode root) {
         if(root.left == null && root.right == null) return true;
         return recur(root, null, null);//
        }

         private boolean recur(TreeNode node, Integer min, Integer max){//题眼, 知识点说明:Integer是可以有null的,但是int是0;
         //不能用int,因为边界条件不能用.
         if(node == null) return true;
            if((max != null && node.val >= max ) || (min != null && node.val <= min)) return false;

             boolean  left = recur(node.left, min, node.val);
             boolean right =  recur(node.right, node.val, max);
             return left && right;
         }

    //利用中序遍历,这个要理解
    /**
     *  List<Integer> list = new ArrayList<Integer>();
     *
     *     public boolean isValidBST(TreeNode root) {
     *         if (root == null) return true;
     *         if (root.left == null && root.right == null) return true;
     *         inOrderTraversal(root);
     *         for (int i = 1; i < list.size(); i++) {
     *             if (list.get(i) <= list.get(i - 1)) return false;
     *         }
     *         return true;
     *      }
     *
     *     public void inOrderTraversal(TreeNode root) {
     *         if (root == null) return;
     *         inOrderTraversal(root.left);
     *         list.add(root.val);
     *         inOrderTraversal(root.right);
     *     }
     */





}
