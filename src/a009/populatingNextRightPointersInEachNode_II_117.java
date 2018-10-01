package a009;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * Example:
 *
 * Given the following binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class populatingNextRightPointersInEachNode_II_117 {
   class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
        public void connect(TreeLinkNode root) {
            if(root == null) return;
            TreeLinkNode nextnode = root.next;
            TreeLinkNode downnext = null;//next lvl next node
            // rootNext如果是null说明已经处理完这一层的所有node
            // next不等于null说明找到了找到最左边的下一个被连接的对象

            while(nextnode != null && downnext == null){
                if(nextnode.left != null){ // left first
                    downnext = nextnode.left;
                    break;
                } else if(nextnode.right != null){
                    downnext = nextnode.right;
                    break;
                }else
                    nextnode = nextnode.next;

            }

            if(root.left != null){
                if(root.right != null) root.left.next = root.right; // inter tree connect
                else root.left.next = downnext;
            }

            if(root.right != null){
                root.right.next = downnext; // cross tree connect
            }

            connect(root.right);//must right first!!!!!!!!!! // 要先让右边都先连起来
            connect(root.left);

        }
}
