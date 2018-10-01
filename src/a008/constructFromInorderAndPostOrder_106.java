package a008;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class constructFromInorderAndPostOrder_106 {
       class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

  }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(postorder.length != inorder.length) return new TreeNode(0);
            TreeNode  res = maketreeip(inorder, postorder, 0,postorder.length - 1, 0, inorder.length - 1);
           return res;
        }

        private TreeNode maketreeipA(int[] inorder, int[] postorder,int poststart, int postend, int instart, int inend){
            if(instart > inend || poststart > postend    )return null;
            if( poststart < 0|| postend > postorder.length  )return null;
            TreeNode current = new TreeNode(postorder[postend]);
            System.out.println(poststart + "   ,<>   "  + postend);
            int i = instart;//这里一定注意,起点不是 "0"!!!!!!!!!!!!!!!!!!!!!!!!!
            while(i <= inend){
                if(inorder[i] == current.val) break;
                i++;
            }
            int leftlength = i - instart;
            current.left = maketreeipA(inorder, postorder, poststart,poststart + leftlength - 1 ,instart, i-1);//注意postend的 那个减1
            current.right = maketreeipA(inorder, postorder, poststart +leftlength, postend - 1,i + 1 ,inend);

            return current;
        }


    public TreeNode maketreeip(int[] inorder,  int[] postorder, int poststart, int postend, int instart, int inend) {

           //非常直观的好程序, 这个办法一定要学会!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (instart == inend)  return new TreeNode(postorder[postend]);
        if (instart > inend) return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int idx = instart;//这里一定注意,起点不是 "0"!!!!!!!!!!!!!!!!!!!!!!!!!
        while (idx < inend && inorder[idx] != postorder[postend]) {
            idx++;
        }
        int leftLength = idx - instart;
        // poststart, poststart + leftLength - 1，前序遍历的左子树的起始，结束位置
        root.left = maketreeip(inorder, postorder,  poststart, poststart + leftLength - 1,instart, idx - 1);
        int rightLength = inend - idx;
        // poststart + leftLength, postend - 1，前序遍历的右子树的起始，结束位置
        root.right = maketreeip(inorder, postorder,  poststart + leftLength, postend - 1,idx + 1, inend);
        return root;
    }


























        public static void main(String[] args){
          int[] in =  {9,3,15,20,7};
            int[] post = {9,15,7,20,3};
            constructFromInorderAndPostOrder_106 t = new constructFromInorderAndPostOrder_106();

            System.out.println(t.buildTree(in, post));


        }
}
