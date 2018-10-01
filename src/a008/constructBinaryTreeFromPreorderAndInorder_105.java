package a008;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class constructBinaryTreeFromPreorderAndInorder_105 {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder.length != inorder.length) return new TreeNode(0);

            TreeNode  res = maketree(preorder, inorder, 0, 0, preorder.length -1);

            return res;
        }

    private  TreeNode maketree(int[] preorder, int[] inorder, int prestart, int instart , int inend){
        if(prestart > preorder.length || instart > inend) return null;//?
        TreeNode current =  new TreeNode(preorder[prestart]);
        int i = instart;
        while(i <= inend){//得到坐标
            if(inorder[i] == current.val)
                break;
            i++;
        }

        current.left = maketree(preorder, inorder, prestart + 1, instart, i - 1);//此处inend 是到 节点前一个元素, 故是 j- 1
        current.right = maketree(preorder, inorder, prestart + 1 +(i - 1 + 1 - instart) , i + 1, inend);
        //此时pre的开始坐标变成 原坐标 加 inorder左子树 长度 的下一个元素, j-1 还原为 j(求子树长度)
        return current;
        }







        //from csdn
        public TreeNode build(int[] preorder, int[] inorder, int preIndex, int startInIndex, int endInIndex) {
            if (endInIndex < startInIndex) return null;
            TreeNode node = new TreeNode(preorder[preIndex]);
            // the index of current node in inorder
            int index = getIndexInInorder(inorder, preorder[preIndex]);
            int lenL = index - startInIndex;//左子树长度
            int lenR = endInIndex - startInIndex - lenL;//右子树长度
            if (lenL > 0) {
                node.left = build(preorder, inorder, preIndex + 1, startInIndex,
                        index - 1);
            }
            if (lenR > 0) {
                node.right = build(preorder, inorder, preIndex + lenL + 1,
                        index + 1, endInIndex);
            }
            return node;
        }

    public int getIndexInInorder(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                return i;
            }
        }
        return -1;
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
