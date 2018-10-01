package a006;

import java.util.List;

/**
 * 86. Partition List
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class partitionList_086 {
    private  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode newhead  = new ListNode(0);
        ListNode tmp = new ListNode(0);
        ListNode  small = newhead;
        ListNode  big = tmp;
        if(head == null) return head;
        //if(head.val > x) return head; //题设没有说是sorted

        while(head != null){
            ListNode temp = new ListNode(head.val);//这步最关键!
            if(head.val < x){//mistake  此处不能有等号
                small.next = temp;
                small = small.next;
            }else if (head.val >= x){//mistake  此处是大等于
                big.next = temp;
                big = big.next;
            }
            head = head.next;
        }
        small.next = tmp.next;

        return newhead.next;
    }
}
