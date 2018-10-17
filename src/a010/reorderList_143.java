package a010;

/**
 * 143. Reorder List
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class reorderList_143 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode right = head;
        ListNode left = head;
        ListNode lefthead = left;
        ListNode mid = getMiddle(head);

        while (left != mid) {
            left = left.next;
        }
        right = left.next;//get right head
        left.next = null;// get left end;
        ListNode righthead = reverse(right);
        ListNode tmp = new ListNode(0);
        head = tmp;
        while( righthead != null){//left != null &&
            tmp.next = lefthead;
            lefthead = lefthead.next;
            tmp = tmp.next ;
            tmp.next =  righthead;
            righthead = righthead.next;
            tmp = tmp.next;
        }
        if(lefthead != null){
            tmp.next = lefthead;
        }

        head = head.next;
    }

    //we need 2 helper method
    // first
    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //second
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
