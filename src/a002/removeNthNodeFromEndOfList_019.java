package a002;
/*
19. Remove Nth Node From End of List
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?


 */
//two pointer
//or slow fast

public class removeNthNodeFromEndOfList_019 {



    //https://www.youtube.com/watch?v=Ny4YACv-skc   ---he answer




    //nodelist zhiyou node.next one method to use!
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode dummy = new ListNode(0);
         dummy.next = head;// this means add an node before head : 0-> 1 ->2 ...;   original: 1->2->3 ... for line 40 ,41
         ListNode slow = dummy;
         ListNode fast = dummy;

        for(int i =0 ; i < n ; i++){//go n times ,means
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;// fast is already at position n
            slow = slow.next;//so the gap between fast and slow is n;
        }
        slow.next = slow.next.next;// cut the nth node, jump slow.net


        return dummy.next;//dummy.next is ->head....  this cant be head or
        //there will be an error at inputMore Details
        //
        //Input:
        //[1]
        //1
        //Output:wrong output
        //[1]
        //Expected:
        //[]
      //  return res;
    }

    public static void main(String[] args){

    }

    //Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}



