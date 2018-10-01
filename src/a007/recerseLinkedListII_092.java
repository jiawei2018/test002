package a007;

/**
 * 92. Reverse Linked List II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */

public class recerseLinkedListII_092 {
      private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

        public ListNode reverseBetween(ListNode head, int m, int n) {
        //翻转链表值重点题,必须牢记
            if(head == null || head.next == null) return head;
            ListNode dummy = new ListNode(0);
            dummy.next = head;//pre?
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            for(int i = 0; i < m; i++){
                pre =pre.next;
                cur = cur.next;
            }

            for(int i = 0; i < n - m; i++){
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next =next;
            }
                return dummy.next;
        }

    public ListNode reverseBetweenA(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prem = dummy;
        ListNode  mnode = head;
        ListNode nnode = head;
        //set prem and mmnode to positions, mnode to pos m, prem.next = mnode
        for(int i = 0; i < m; i++){
            mnode = mnode.next;
            prem = prem.next;
        }

        //set nnode to position n
        for(int i = 0; i < n; i++){
            nnode = nnode.next;
        }

        //the method from wang
        //每次都把m点弄出来,放到n后面,直到m == n
        while(mnode != nnode){
            prem.next = mnode.next;
            mnode.next = nnode.next;
            nnode.next = mnode;
            mnode = prem.next;
        }
        return dummy.next;
    }






        private void f(ListNode head){
          //reverse linkedlist
            ListNode pre = null;
            while(head != null){
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }

        }


}
