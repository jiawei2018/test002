package a007;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class uniqueBinarySearchTreeII_095 {
    //二叉排序树或者是一棵空树，或者是具有下列性质的二叉树：
    //（1）若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
    //（2）若右子树不空，则右子树上所有结点的值均大于它的根结点的值；
    //（3）左、右子树也分别为二叉排序树；
    //（4）没有键值相等的节点。


        public static void main(String[] args){
            uniqueBinarySearchTreeII_095 t = new uniqueBinarySearchTreeII_095();
            System.out.println(t.generateTrees(3) );
        }


        public List<TreeNode> generateTrees(int n) {
            //List<TreeNode> res = new ArrayList<>();
            if( n == 0) return new ArrayList<>();
            return recur(1, n);//
        }

        private List<TreeNode> recur(int start, int end){
            List<TreeNode> res = new ArrayList<>();
            if(start >  end) res.add(null);
            for(int i = start; i <=  end; i++){//此处如果是 < 则 最后结果是空, 必须是<= 才有结果,为什么?
                //因为最后如果走到一个元素的时候
                List<TreeNode> leftsub = recur(start, i -1);
                List<TreeNode> rightsub = recur(i + 1, end);
                for(TreeNode left : leftsub ){
                    for(TreeNode right : rightsub){
                        TreeNode tmp = new TreeNode(i);//这个就是 如何 初始化一个 node
                        tmp.left = left;
                        tmp.right = right;
                        res.add(tmp);
                    }
                }
            }
            return res;
        }


          class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }

}
