package a002;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
  class ListNode {
   int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }
 /
 *

class Solution {
 *

    public ListNode mergeKLists(ListNode[] lists) {
 *if (lists == = null || lists.length = 0) {
 *return null;
 *}
 *PriorityQueue<ListNode> minheap = new PriorityQueue<>(new Comparator {
 *
         *@Override
 *
        })
 *
 *}
 */

public class mergeKtSortedLists_23_hard {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minheap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val == o2.val) {
                    return 0;
                } else {
                    return o1.val < o2.val ? -1 : 1;
                }
            }
        });
       // minheap.a


        return null;
    }
}