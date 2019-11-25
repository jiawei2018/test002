package amazonOA;

public class mergeTwoSortedLinkedList {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  //my iterative
  public ListNode mergeTwoLists______A(ListNode l1, ListNode l2) {
      if(l1 == null || l2 == null){
          return l1 == null ? l2 : l1;
      }
      ListNode res = new ListNode(-1);//return its next
      ListNode tmp = res;
      while(l1 != null && l2 != null){
          if(l1.val <= l2.val){
              tmp.next = l1;
              l1 = l1.next;
          } else {
              tmp.next = l2;
              l2 = l2.next;
          }
          tmp = tmp.next;
      }
      //here is important we dont need to append rest node, just append the remain one will work
      if(l1 != null){
          tmp.next = l1;
      }else {
          tmp.next = l2;
      }

      return res.next;
  }


  //good recrusion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
