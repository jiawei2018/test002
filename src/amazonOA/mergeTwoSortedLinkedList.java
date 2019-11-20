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
              tmp.next = new ListNode(l1.val);
              l1 = l1.next;
          } else {
              tmp.next = new ListNode(l2.val);
              l2 = l2.next;
          }
          tmp = tmp.next;
      }
      while(l1 != null){
          tmp.next = new ListNode(l1.val);
          l1 = l1.next;
          tmp = tmp.next;
      }
      while(l2 != null){
          tmp.next = new ListNode(l2.val);
          l2 = l2.next;
          tmp = tmp.next;
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
