package a010;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. Sum Root to Leaf Numbers
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * 1
 * / \
 * 2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 * <p>
 * Input: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class sumRootToLeafNumbers_129 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


       // List<String> res = new ArrayList<>();
        public int sumNumbers(TreeNode root) {
        //改成这样就可以极大速度提升,我原来想的太乱七八糟了,而且对recursion 理解不够
            int[] res = new int[1];
            int[] temp = new int[1];
            if(root == null )
                return 0;

            recur(root ,   res, temp);//只能有这句,说明我对recur还是朦朦胧胧
            return res[0];

        }
        // not tested
        private void   recur(TreeNode root,  int[] res, int[] temp ){
            temp[0] = temp[0] * 10 + root.val;
            if(root.left == null && root.right == null){
                res[0] += temp[0];
                return;
            }

            if(root.left != null){
                recur(root.left,  res, temp);
                temp[0] /= 10;//back track
            }

            if(root.right != null){
                recur(root.right,  res, temp);
                temp[0] /= 10;//back track
            }
        }

    }


    /**
     * public int sumNumbers(TreeNode root) {
     *             List<String> res = new ArrayList<>();
     *             if(root == null )
     *                 return 0;
     *
     *                 recur(root ,   res, "");
     *
     *             int sum = 0;
     *             for(int i = 0; i < res.size(); i++){
     *                 sum += Integer.valueOf(res.get(i));
     *             }
     *
     *             return sum;
     *
     *         }
     *         // not tested
     *         private void   recur(TreeNode root,  List<String> allnums, String temp ){
     *             if(root.left == null && root.right == null){
     *                 temp = temp + root.val;
     *                 allnums.add(temp);
     *                 return;
     *             }
     *
     *             if(root.left != null){
     *                 temp = temp + root.val;
     *                 recur(root.left,  allnums, temp);
     *                 if(temp.length() > 0)
     *                     temp =  temp.substring(0, temp.length() - 1);
     *             }
     *
     *             if(root.right != null){
     *                 temp = temp + root.val;
     *                 recur(root.right,   allnums, temp);
     *                 if(temp.length() > 0)
     *                     temp =  temp.substring(0, temp.length() - 1);
     *             }
     *
     *         }
     */





