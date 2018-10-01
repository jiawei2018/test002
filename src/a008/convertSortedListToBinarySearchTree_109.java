package a008;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem,
 * a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class convertSortedListToBinarySearchTree_109 {
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

 class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> arr = new ArrayList<>();
            ListNode dummy = head;
            while(dummy != null){
                arr.add(dummy.val);
                dummy = dummy.next;
            }
            if(arr.size() == 0) return null;
            TreeNode res = maketree(arr, 0 , arr.size() - 1);
            return res;
        }

        private TreeNode maketree(List<Integer> nums, int left, int right){
            if(left > right) return null;
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums.get(mid));
            root.left  = maketree(nums, left,mid - 1);
            root.right = maketree(nums, mid + 1, right);
            return root;
        }

}
