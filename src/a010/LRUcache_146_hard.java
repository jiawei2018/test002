package a010;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache

 Design and implement a data structure for Least Recently Used (LRU) cache.
 It should support the following operations: get and put.

 get(key) - Get the value (will always be positive)
 of the key if the key exists in the cache, otherwise return -1.

 put(key, value) - Set or insert the value if the key is not already present.
 When the cache reached its capacity,
 it should invalidate the least recently used item before inserting a new item.

 Follow up:

 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2   capacity   )
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */
public class LRUcache_146_hard {
    class LRUCache {

        // 重点题!


        //o(1)?
        //hashmap put and get time complexity is o(1);
        final int  capacity;
        int count = 0;
        int recentkey = 0;
        Map<Integer, Integer> map = new HashMap<>();

        Map<Integer, Integer> times = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
           // tmp = new int[capacity][capacity];
        }

        public int get(int key) {
            recentkey = key;
            if(map.get(key) != null) {
                return map.get(key);
            }else
                return -1;
        }

        public void put(int key, int value) {

            if(count < capacity){
                map.put(key, value);
                times.put(1, key);
            }else{
                //map.remove(recentkey);

                map.put(key, value);
            }
        }

            //map<times,  key>;
        // it should invalidate the least recently used item before inserting a new item.
        private int lrecent(){
            return 0;
        }


    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}

//from  net
/**
import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> cache;
    private DoublyLinkedList visited;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Node>();
        this.visited = new DoublyLinkedList();
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            this.visited.set_head(node);
            return node.value;
        }
        return -1 ;
    }

    public void put(int key, int value) {
        if(this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            node.value = value;
            this.visited.set_head(node);
        }
        else {
            if (this.visited.size >= this.capacity) {
                Node tail_node = this.visited.tail;
                this.visited.remove(tail_node);
                this.cache.remove(tail_node.key);
            }
            Node node = new Node(key, value);
            this.visited.insert(node);
            this.cache.put(key, node);
        }
    }

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public void insert(Node node) {
            // Insert a node to the head
            node.next = this.head;
            if (this.head != null) {
                this.head.prev = node;
            }
            else {
                this.tail = node;
            }
            this.head = node;
            this.size += 1;
        }

        public void set_head(Node node) {
            Node prev_node = node.prev;
            Node post_node = node.next;

            if(prev_node != null) {
                prev_node.next = post_node;
                if (post_node != null) {
                    post_node.prev = prev_node ;
                }
                else {
                    this.tail = prev_node;
                }
                node.next = this.head;
                node.prev = null;
                this.head.prev = node;
                this.head = node;
            }
        }

        public void remove(Node node) {
            Node prev_node = node.prev;
            Node post_node = node.next;
            if(prev_node != null) {
                prev_node.next = post_node;
            }
            else {
                this.head = post_node;
            }
            if (post_node != null) {
                post_node.prev = prev_node;
            }
            else {
                this.tail = prev_node;
            }
            this.size -= 1;
        }

    }
}


//again other
 import java.util.*;
class Node{
    int key;
    int value;
    Node next;
    Node pre;
    public Node(int key,int value,Node pre, Node next){
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.next = next;
    }
}

public class LRUCache {
    int capacity;
    int count;//cache size
    Node head;
    Node tail;
    HashMap<Integer,Node>hm;
    public LRUCache(int capacity) {
        //only initial 2 Node is enough, head/tail
        this.capacity = capacity;
        this.count = 2;
        this.head = new Node(-1,-1,null,null);
        this.tail = new Node(-2,-2,this.head,null);
        this.head.next = this.tail;
        hm = new HashMap<Integer,Node>();
        hm.put(this.head.key, this.head);
        hm.put(this.tail.key, this.tail);
    }
    public int get(int key) {
        int value = -1;
        if(hm.containsKey(key)){
            Node nd = hm.get(key);
            value = nd.value;
            detachNode(nd); //detach nd from current place
            insertToHead(nd); //insert nd into head
        }
        return value;
    }
    public void put(int key, int value) {
        if(hm.containsKey(key)){ //update
            Node nd = hm.get(key);
            nd.value = value;
            //move to head
            detachNode(nd); //detach nd from current place
            insertToHead(nd); //insert nd into head
        }else{ //add
            Node newNd = new Node(key,value,null,this.head);
            this.head.pre = newNd; //insert into head
            this.head = newNd;
            hm.put(key, newNd); //add into hashMap
            this.count ++;
            if(this.count > capacity){ //need delete node
                removeNode();
            }
        }
    }
    //common func
    public void insertToHead(Node nd){
        this.head.pre = nd;
        nd.next = this.head;
        nd.pre = null;
        this.head = nd;
    }    public void detachNode(Node nd){
        nd.pre.next = nd.next;
        if(nd.next!=null){
            nd.next.pre = nd.pre;
        }else{
            this.tail = nd.pre;
        }
    }
    public void removeNode(){ //remove from tail
        int tailKey = this.tail.key;
        this.tail = this.tail.pre;
        this.tail.next = null;
        hm.remove(tailKey);
        this.count --;
    }    public void printCache(){
        System.out.println("\nPRINT CACHE ------ ");
        System.out.println("count: "+count);
        System.out.println("From head:");
        Node p = this.head;
        while(p!=null){
            System.out.println("key: "+p.key+" value: "+p.value);
            p = p.next;
        }
        System.out.println("From tail:");
        p = this.tail;
        while(p!=null){
            System.out.println("key: "+p.key+" value: "+p.value);
            p = p.pre;
        }
    }
    public static void main(String[] args){
        LRUCache lc = new LRUCache(3);
        lc.printCache();
        lc.put(1, 1);
        lc.put(2, 2);
        lc.put(3, 3);
        lc.printCache();
        lc.get(2);
        lc.printCache();
        lc.put(4, 4);
        lc.printCache();

        lc.get(1);
        lc.printCache();
        lc.put(3, 33);
        lc.printCache();
    }
}
*/
