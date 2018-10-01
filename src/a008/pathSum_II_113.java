package a008;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 113. Path Sum II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class pathSum_II_113 {
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public List<List<Integer>> pathSumB(TreeNode root, int sum) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stnode = new Stack<>();
        Stack<Integer> stsum = new Stack<>();
        Stack<List<Integer>> stlist = new Stack<>();//关键句子
        stnode.push(root);
        stsum.push(sum);
       // List<Integer>  temp  = new ArrayList<>();
        stlist.push(new ArrayList<>());
        while(!stnode.isEmpty()){
            TreeNode curr  = stnode.pop();
            List<Integer> curtmp = stlist.pop();
            int cursum = stsum.pop();
            curtmp.add(curr.val);
            if(curr.left == null && curr.right == null && curr.val == cursum){
                res.add(new ArrayList<>(curtmp));
            }

            if(curr.left != null){
                stnode.push(curr.left);
                stsum.push(cursum - curr.val);
                stlist.push(new ArrayList<>(curtmp));//关键句子
            }

            if(curr.right != null){
                stnode.push(curr.right);
                stsum.push(cursum - curr.val);
                stlist.push(new ArrayList<>(curtmp));//关键句子
            }
        }
        return res;
    }










        public List<List<Integer>> pathSum(TreeNode root, int sum) {

            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;
            List<Integer>  temp  = new ArrayList<>();
            getPath(res, temp, sum, root);

            return res;
        }

        private void getPathA(List<List<Integer>> res, List<Integer> temp, int sum, TreeNode root){
            if(root == null) return;
            temp.add(root.val);
            if(root.left == null && root.right == null && root.val == sum){
                res.add(new ArrayList<>(temp));
            }
            getPath(res, new ArrayList<>(temp), sum - root.val, root.left);//核心 在1这一句 new  要用熟练这招
            getPath(res, new ArrayList<>(temp), sum - root.val, root.right);//核心 在1这一句 new要用熟练这招
        }



    private void getPath(List<List<Integer>> res, List<Integer> temp, int sum, TreeNode root){
        if(root == null) return;
        temp.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            // temp.add(root.val);
            res.add(new ArrayList<>(temp));
        }
        getPath(res,  temp, sum - root.val, root.left);
        getPath(res,  temp, sum - root.val, root.right);
        temp.remove(temp.size() - 1);//关键在于这一句话,   回溯  在这里
        //这句话 理解 我现在是这样想,当 上面两个摸一个执行后则在他自身内已经加了一个属于自己的 root.val;
        //那么对于连一个 reecursion 来说这个就是不用的,说白了,
        // 就是把自己加上的这个元素在干完活以后自己再删除掉,不要影响别人取用数据
    }

}
