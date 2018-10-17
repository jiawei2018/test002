package a011;

import java.util.List;

/**
 * 148. Sort List
 DescriptionHintsSubmissionsDiscussSolution
 Pick One

 Sort a linked list in O(n log n) time using constant space complexity.

 Example 1:

 Input: 4->2->1->3
 Output: 1->2->3->4
 Example 2:

 Input: -1->5->3->4->0
 Output: -1->0->3->4->5
 */
public class sortList_148 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
//o(nlogn)   merge sort?   quick sort?

        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            //whaat ever thanks laioffer, i finished thisone

            return  sort(head);
        }

        private ListNode  sort(ListNode head ){
            if(head.next == null){//length is 1
                return head;
            }

            ListNode mid = getmid(head);
            ListNode right = mid.next;//right = head/2;
            mid.next = null; // now head = head/2;

            return merge( sort(head), sort(right));
        }

        private ListNode merge(ListNode n1, ListNode n2){
        if(n1 == null || n2 == null){
            return n1 == null ? n2 : n1;
        }

            ListNode dummy = new ListNode(0);
            ListNode res = dummy;
            while(n1 != null && n2 != null){
                if( n1.val < n2.val){
                    dummy.next = new ListNode(n1.val);
                    n1 = n1.next;
                    dummy = dummy.next;
                }else{
                    dummy.next = new ListNode(n2.val);
                    n2 = n2.next;
                    dummy = dummy.next;
                }
            }

            while(n1 != null){
                dummy.next = new ListNode(n1.val);
                n1 = n1.next;
                dummy = dummy.next;
            }

            while(n2 != null){
                dummy.next = new ListNode(n2.val);
                n2 = n2.next;
                dummy = dummy.next;
            }
            return res.next;

        }



        private ListNode getmid(ListNode head){
              if(head == null) return null;
                ListNode fast = head;
                ListNode slow = head;

                while(fast.next != null && fast.next.next != null){
                    slow = slow.next;
                    fast = fast.next.next;
                }
            return slow;
        }




}
