package a013;

/**
 * 203.
 * Remove Linked List Elements
 * Difficulty
 * Easy

 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class removeLinkedListEle_203 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
     }

        public ListNode removeElements(ListNode head, int val) {
            if(head == null){
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode node = dummy;
            while(node.next != null){
                if(node.next.val == val){
                    node.next = node.next.next;
                }else {
                    node = node.next;
                }
            }
            return dummy.next;
        }
}
