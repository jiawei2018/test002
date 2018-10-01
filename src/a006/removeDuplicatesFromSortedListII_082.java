package a006;

/**
 * 82. Remove Duplicates from Sorted List II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class removeDuplicatesFromSortedListII_082 {
    /**
     */ //Definition for singly-linked list.
     private  class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

        public ListNode deleteDuplicates(ListNode head) {
         //youtube cspiration那个人的课件
            if(head == null ||head.next == null) return head;//mistake// must !   head , and head.next is not null
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode helper = dummy;

            while(helper.next != null && helper.next.next != null){
                if(helper.next.val == helper.next.next.val){
                    int val =  helper.next.val;
                    while(helper.next != null && helper.next.val == val){//mistake  //must not null
                        helper.next = helper.next.next;//这个next就是1下次循环的next, 切掉一个
                    }
                }else
                    helper = helper.next;
            }
            return dummy.next;
        }

}
