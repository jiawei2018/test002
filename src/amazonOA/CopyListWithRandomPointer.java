package amazonOA;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    //leetcode 138 with new signature
    //A linked list is given such that each node contains an additional random pointer
    // which could point to any node in the list or null.
    //
    //Return a deep copy of the list.

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        //we  use map to record the <new , old> node pair
        if(head == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val, null, null);
        Node res = newHead;
        map.put(head, newHead);//DO NOT FORGET THIS !!!!!!!!!!!!!!!!!!!!!!!!
        while(head != null) {
            if(head.next != null){
                if(!map.containsKey(head.next)){
                    Node next = new Node(head.next.val, null, null);
                    map.put(head.next, next);
                }
                newHead.next = map.get(head.next);
            }

            if(head.random != null){
                if(!map.containsKey(head.random)){
                    Node random = new Node(head.random.val, null, null);
                    map.put(head.random, random);
                }
                newHead.random = map.get(head.random);
            }
            head = head.next;
            newHead = newHead.next;
        }
        return res;
    }





}
