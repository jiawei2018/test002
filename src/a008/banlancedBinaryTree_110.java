package a008;

/**
 * 110. Balanced Binary Tree
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 */
public class banlancedBinaryTree_110 {
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;
            int ldiff = root.left == null ? 0:isbl(root.left, 1);

            int rdiff = root.right == null ? 0:isbl(root.right, 1);
            if(Math.abs(ldiff - rdiff) > 1) return false;
            else
              return  isBalanced(root.left) && isBalanced(root.right);//注意这里,这才是扣子,题眼

        }

        private int isbl(TreeNode root, int depth){//这个只是求出来最大深度
            //int l = depth, r = depth;
            if(root == null)  return depth;
            if(root.right != null ||root.left != null ) {
                depth ++;
                return Math.max(isbl(root.left,  depth), isbl(root.right, depth)  );
            }else
                return depth;
        }

//not working
// public boolean isBalancedA(TreeNode root) {
//         boolean  ok = true;
//          recursion(root, ok);
//          return ok;
//      }
//
//  	private int recursion(TreeNode root, boolean ok) {
//  		if(root == null || !ok) return 0;
//  		int ha = recursion(root.left, ok);
//  		int hb = recursion(root.right, ok);
//  		if(Math.abs(ha - hb) > 1) ok = false;
//  		     return Math.max(ha, hb) + 1;
//     }







//    public boolean isBalancedA(TreeNode root) {
//        if(root == null) return true;
//
//            return  isBalanced(root.left) && isBalanced(root.right);//注意这里,这才是扣子,题眼
//
//    }
//        private  boolean isbnew(TreeNode root, int edge){
//            if(edge > 2) return false;
//            if(root.left == null && root.right != null){
//                edge++;
//                return isbnew(root.right, edge);
//            }else if(root.left != null && root.right == null){
//                edge++;
//                return isbnew(root.left, edge);
//            }else
//               return isbnew(root.left, edge) && isbnew(root.right, edge);
//        }


}
