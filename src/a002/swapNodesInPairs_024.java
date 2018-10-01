package a002;

/**
 * 24. Swap Nodes in Pairs
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 *
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */

public class swapNodesInPairs_024 {
    //注意要求!
       private class ListNode {
           int val;
           ListNode next;
           ListNode(int x) { val = x; }
       }


        public ListNode swapPairs(ListNode head) {
            // 链表只有一个节点或没有节点直接返回
            if (head == null || head.next == null)
            {
                return head;
            }
            // 创建两个暂存指针，指向head和head的下一个元素
            ListNode pre = head;
            ListNode nex = head.next;
            // 因为交换改变了head，所以head需要移动到下一个元素
            head = head.next;
            ListNode res = null;
            //  等于空时，只有一个元素，不用进行交换
            while(nex != null)
            {
                if(res != null)//这个是重点!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    //结合图看https://blog.csdn.net/camlot_/article/details/51774457
                {
                    res.next = nex;  // ③    ||2. res before 1-3-4 , 1-4?
                }
                pre.next = nex.next;  // ①   pre is 1-3-4     nex is 2-3-4  || 2. p is 3
                nex.next = pre;  // ②  nex is 2-1-3-4                       || 3.nex is 4-3
                res = pre;      // res  is 1-3-4                            ||res is 3 -4
                pre = pre.next;  // pre向后移动到pre’       pre  is 3-4                || pre is null
                // 当p为空时，后面就没有节点了，证明操作已经完成
                if(pre == null) break;                                      //|| break
                nex = pre.next;  // nex向后移动到q’     nex is 4
            }
            return head;
        }

    public ListNode swapPairsB(ListNode head) {//recursion   牧场沉默人understandable!!!!!!!!
        if (head == null || head.next == null) return head;

        ListNode tmp = head.next;//tmp 2-3-4
        head.next = swapPairs(tmp.next);//head.next is 2-3-4 ,and head is 1-2-3-4  now tmp.next  is 3-4-
        //so after this is head 1-3-4
        tmp.next = head;//tmp.next is 3-4-...

        return tmp;
    }
        /*这个例子ju的很好

        链接有图,更加直观
        https://blog.csdn.net/nomasp/article/details/49803287

        先来看看如何交换两个节点吧~

也以“1 -> 2 -> 3 -> 4”作为例子，交换前两个即可。

错误示例1：

ListNode tmp = head.next;
tmp.next = head;
head.next = tmp;
1
2
3
它将以此变成：

tmp -> head -> tmp -> head -> tmp
2 -> 1 -> 2 -> 1 -> 2 -> 1 ...
1
2
正确示例：

ListNode tmp = head.next;
// become : 2 -> 3 -> 4
head.next = tmp.next;
// become : 1 -> 3 -> 4
tmp.next = head;
// become : 2 -> 1 -> 3 -> 4
1
2
3
4
5
6
如何要对后续的元素也进行swap，只用递归替换掉tmp.next即可。

ListNode* temp = head->next;
head->next = swapPairs(temp->next);
temp->next = head;
1
2
3
我们就以题目中给出的1，2，3，4作为示例，将其作为两部分

1，2 -- 3，4
1
或者我画个图出来更加直观吧……

         */


        public static void main(String[] args){

        }


}
