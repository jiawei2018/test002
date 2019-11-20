package a015;

/**
 * 226.
 * Invert Binary Tree
 * Difficulty
 * Easy

 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), b
 * ut you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class invertBinaryTree_226 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return root;
            }

            TreeNode left = invertTree(root.right);
            TreeNode right = invertTree(root.left);
            root.left = left;
            root.right = right;
            return root;
        }


}
