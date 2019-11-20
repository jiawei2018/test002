package a015;



/**
 * 124. Binary Tree Maximum Path Sum
 * Hard
 * 1072
 * 85
 * <p>
 * <p>
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along
 * the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */
public class BinaryTreeMaxinumPathSum_124 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return Integer.MIN_VALUE;// wired
        }
        int[] max = new int[1];
        max[0] = root.val;
        recur(root, max);
        return max[0];
    }

    private int recur(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }

        int tmpl = recur(root.left, max);
        int tmpr = recur(root.right, max);
        int left = tmpl > 0 ? tmpl : 0;//扔掉小于0的值 ,带有东山再起的意思
        int right = tmpr > 0 ? tmpr :0;

        max[0] = Math.max(max[0], left + right + root.val );
        return Math.max(left , right) + root.val;
    }

}
