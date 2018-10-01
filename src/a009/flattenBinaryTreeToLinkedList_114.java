package a009;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 114. Flatten Binary Tree to Linked List
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class flattenBinaryTreeToLinkedList_114 {
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left != null) {
                    TreeNode pre = root.left;//pre is the root of the right sub-tree

                    while (pre.right != null)
                        pre = pre.right;//走到左子树的最右节点,这个节点后面就是右子树
                    pre.right = root.right;// 接上右子树
                    root.right = root.left;//此时左子树是 左子树+ 右子树,所以这样
                    root.left = null;//左边清空
                }
                root = root.right; //走到下一个右孩子上面
            }
        }

}
