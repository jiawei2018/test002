package a005;

/**
 * 61. Rotate List
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class rotateList_061 {
     // Definition for singly-linked list.
       private class ListNode {
       int val;
      ListNode next;
       ListNode(int x) { val = x; }
   }

    public ListNode rotateRight(ListNode head, int k) {
           //对于listnode 题还是很不熟悉,,,,,,
        //画图
        /**
         *     思路：我们首先计算单链表的结点个数n。因为可能存在k > n的情况，
         *     先进行取模计算k = k % n。初始化指针pre = head、p = head、q = head。
         *     接下来分为三步走：① 将指针q往右移动k次；② 在指针q指向结点的next指针不为空时，
         *     同时向右移动指针pre和指针q，那么指针pre就指向了返回单链表首结点的前驱结点；
         *     ③p = pre->next指向返回单链表的首结点，pre->next = NULL使得指针pre指向结点为新的尾结点，
         *     q->next = head进行重新连接，返回指针p即可 。
         *     时间复杂度为O(n)。
         */
        if(head == null) return head;
        ListNode res = new ListNode(0);

        //快慢双指针的运用
        ListNode slow = head;
        ListNode fast = head;
        ListNode tmp = head;
        int count = 0;
        while(tmp != null){
            // System.out.println(count);
            count++;
            tmp = tmp.next;
        }
        // System.out.println(count);
        k %= count; //题点
        //System.out.println(k);
        //     //mistake   gap 就是 k!!!!!不是   count- k
        while(k >  0){
            fast = fast.next;
            k--;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;//本来 fast.next == null;
        head = slow.next;//head 本来 是 1->2;  变为 4->5
        slow.next = null;//

        return head;
    }




}
