package a011;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 160. Intersection of Two Linked Lists
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * Credits:
 * Special thanks to @stellari for adding this problem and creating all test cases.
 */
public class intergsectionsOfTwoLinkedList_160 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode dummy = new ListNode(0);
            ListNode a = headA;
            ListNode b = headB;
            if(headA == null || headB == null){
                return null;
            }
            Map<ListNode, ListNode> map = new HashMap<>();
            int idx = 0;
            while(a != null && b != null){
                map.put(a, a);
                a = a.next;
            }

            while(b != null){
                if(map.containsKey(b)){
                    dummy.next = map.get(b);
                    break;
                }else{
                    b = b.next;
                }
            }
            return dummy.next;
        }

    public ListNode getIntersectionNodeA(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        ListNode dummy = new ListNode(0);

        while(a.next != null){//get tail node of a
            a = a.next;
        }

        a.next = b;
        ListNode slow = headA;
        ListNode fast = headA;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null ){//mis
            a.next = null;
            return null;
        }
        slow = headA;//mstake key point ,slow must start from begin
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        a.next = null;
        return slow;
    }
}
