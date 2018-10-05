package a010;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 A linked list is given such that each node contains an additional random pointer
 which could point to any node in the list or null.

 Return a deep copy of the list.


 */
public class copyListWithRandowPointers_138 {
    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;

        Map<RandomListNode, RandomListNode> map =  new HashMap<>();

        RandomListNode dummy = new RandomListNode(0);
        RandomListNode dummyhead = dummy;
        RandomListNode tmphead = head;

        while(tmphead != null){
            dummy.next = new RandomListNode(tmphead.label);
            map.put(tmphead, dummy.next);
            dummy = dummy.next;
            tmphead = tmphead.next;
        }

        tmphead = head;
        dummy = dummyhead;

        while(tmphead != null){
            dummy.next.random = map.get(tmphead.random);//this will return a node in dummy;
            dummy = dummy.next;
            tmphead = tmphead.next;
        }
        return dummyhead;
    }
}
