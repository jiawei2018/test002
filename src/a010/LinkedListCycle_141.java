package a010;

/**
 * 141. Linked List Cycle
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Given a linked list, determine if it has a cycle in it.

 Follow up:

 Can you solve it without using extra space?

 1-2-3-4-5-2-3-4-5....


 */
public class LinkedListCycle_141 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
        public boolean hasCycle(ListNode head) {
        if(head == null) return true;
        //这是来自课上的提示
        ListNode fast = head;
        ListNode slow = head;
        while(slow != null && fast.next != null && fast.next.next != null){
            if(fast.next == slow ){//the key !!!!!!!!!!!!!!!!!!
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

            return false;
        }
}
