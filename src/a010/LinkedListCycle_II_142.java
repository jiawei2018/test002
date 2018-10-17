package a010;

/**
 * 142. Linked List Cycle II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle_II_142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        //首先如图所示，链表的整个长度为L，链表头head为h，假设fp和sp按照箭头所示的方向走。
        // 其中环入口点为d，h到d的距离hd为a。fp和sp假设初次相遇在c，
        // 初次相遇的时候慢指针sp肯定没有走完整个链表。设d到c的距离dc为x，
        // h到c的距离即为sp初次相遇所走的路程，即设hc长度为s。此外设环的长度为r。
        // 而在fp和sp初次相遇在c点的时候，fp则在环内已经走了n圈。由于fp的速度是sp的2倍，接下来我们可以得出：
        //2s = s + nr
        //->    s = nr  (1)
        //又因为hd距离为a，dc距离为x，hc距离为s，所以可以得出：
        // a + x = s   (2)
        //结合(1)和(2)可以得出：
        //a + x = nr   ->    a + x = (n-1)r + r   ->    a + x = (n-1)r + (L-a)        注释：L-a即为环长r
        //->     a = (n-1)r + (L-a-x)
        //即此时h到d的距离a等于c到d的距离(L-a-x)。所以当fp和sp初次相遇在c点的时候，令fp从c点出发，sp指向
        //链表头h，两个同时以步数为1同时出发，则再次相遇的时候即为环的入口节点d。
        //

        // 1--a--2--b--3--c--2, first meet ,fast = a+ b+ C +b   ,slow = a + b,
        //and fast = 2* slow so a +b+c+b = 2(a+b); so c ==a ,so let fast and slow stop here
        //and slow an fast go at same speed ,when they meet ,tere will be the answer
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;//impotant
            fast = fast.next.next;//关键的3句,还是按照孙老师是说的,用0,1,2各元素跑一边就行
            //所以这个要多吸收老师的经验!!!!!!!!!!!!!!!!!!!
            if (fast == slow) {   //此处判断必须在slow,fast先走了之后进行,否则无法通过
                break;
            }
        }
        if (fast.next == null && fast.next.next == null) {
            return null;
        }
        fast = slow;
        slow = head;
        while (fast != slow) {

            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


//    public ListNode detectCycle(ListNode head) {
//
//        if (head == null || head.next == null) {
//            return null;
//        }
//// 快指针fp和慢指针sp，
//       // ListNode fp = head, sp = head;
//       // while (fp != null && fp.next != null) {
//            sp = sp.next;
//            fp = fp.next.next;
////此处应该用fp == sp ，而不能用fp.equals(sp) 因为链表为1 2 的时候容易
//            //抛出异常
//            if (fp == sp) {  //说明有环
//                break;
//            }
//        }
//        //System.out.println( fp.val + "   "+ sp.val );
//        if (fp == null || fp.next == null) {
//            return null;
//        }        //说明有环，求环的起始节点
//        sp = head;
//        while (fp != sp) {
//            sp = sp.next;
//            fp = fp.next;
//        }
//        return sp;
//    }
}




