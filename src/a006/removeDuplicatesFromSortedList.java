package a006;

/**
 * 83. Remove Duplicates from Sorted List
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class removeDuplicatesFromSortedList {
    private  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private ListNode deleteDuplicates(ListNode head) {
        //所有listnode的题我都觉得非常抽象而无法正常思考????
        //需要找到一套自己的方法来对付这个情况
        //不管如何,先画图才行
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null){
            if(fast.val == slow.val){
                slow.next = fast.next;
                fast = fast.next;
            }else{
                slow = slow.next;
                fast = fast.next;
            }
        }
        return head;
    }

}
