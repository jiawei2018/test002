package a010;

import java.util.List;

/**
 * 147. Insertion Sort List
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Sort a linked list using insertion sort.


 A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list


 Algorithm of Insertion Sort:

 Insertion sort iterates, consuming one input element each repetition,
 and growing a sorted output list.

 At each iteration, insertion sort removes one element from the input data,
 finds the location it belongs within the sorted list, and inserts it there.

 It repeats until no input elements remain.

 Example 1:

 Input: 4->2->1->3
 Output: 1->2->3->4
 Example 2:

 Input: -1->5->3->4->0
 Output: -1->0->3->4->5
 */
public class insertionSortList_147 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
     public ListNode insertionSortList(ListNode head) {
         if (head == null || head.next == null){
             return head;
         }

       ListNode res = new ListNode(head.val);
       ListNode dummy = res;
       ListNode tmp = head;


         tmp = tmp.next;
       while(tmp != null){
           ListNode n = new ListNode(tmp.val);
           if(n.val < dummy.val){
               n.next = dummy;
               dummy = n;
               res = dummy;
           }else{
               System.out.println(n.val + "  " + dummy.val);
               while( dummy.next != null && n.val > dummy.next.val){
                   dummy = dummy.next;
               }
               ListNode n1 = new ListNode(n.val);
               n1.next = dummy.next;
               dummy.next = n1;
           }
           dummy = res;
           tmp = tmp.next;
       }
       return res;
     }
}
