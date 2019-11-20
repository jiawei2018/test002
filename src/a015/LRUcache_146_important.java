package a015;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 146.
 * LRU Cache
 * Difficulty
 * Hard

 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 /* capacity
 */

//        cache.put(1,1);
//        *cache.put(2,2);
//        *cache.get(1);       // returns 1
//        *cache.put(3,3);    // evicts key 2
//        *cache.get(2);       // returns -1 (not found)
//        *cache.put(4,4);    // evicts key 1
//        *cache.get(1);       // returns -1 (not found)
//        *cache.get(3);       // returns 3
//        *cache.get(4);       // returns 4

public class LRUcache_146_important {//非常重要
    class LRUCache {

        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

        }
        Map<Integer, Node> map = new HashMap<>();
        int capacity;
        int count;
        Node head;
        Node tail;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = null;
            tail = null;
        }

        public int get(int key) {
            Node cur = map.get(key);
            if( cur == null){
                return -1;
            }
            if(cur != tail){
                if(cur == head){
                    head = head.next;
                }else{//cur is middle
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                tail.next = cur;
                cur.next = null;
                cur.prev = tail;
                tail = cur;
            }
             return tail.value;
        }

        public void put(int key, int value) {
            Node cur = map.get(key);
            if(cur != null){
                cur.value = value;// update value !!!!!
                if(cur != tail){
                    if(cur == head){
                        head = head.next;
                    }else{//cur is middle
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }
                    tail.next = cur;
                    cur.next = null;
                    cur.prev = tail;
                    tail = cur;
                }

            }else{ // wedont have this node in map
                Node newone = new Node(key,value);
                if(capacity == 0){// cache is full
                    map.remove(head.key);
                    head = head.next;
                    capacity++;
                }
                if(head == null && tail == null){// empty cache
                    head = newone;
                } else {
                    tail.next = newone;
                    newone.prev = tail;
                    newone.next = null;
                }
                tail = newone;  //dont miss
                map.put(key, newone); // dont miss
                capacity--; // dont miss
            }
        }
    }




/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}


/**
 * 你遇到过这个题吗？
 * 实现一个LRU Cache。要求查询和插入都在O(1) 时间内完成。
 * 遇到过？很正常。
 * 没遇到？早晚会遇到。（鬼脸）
 * 这是LeetCode上一道十分经典的题目，也是非常火的面试题。
 * <p>
 * 原题：
 * <p>
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * <p>
 * 根据操作系统所学：cache（缓存）可以帮助快速存取数据，但是容量小。
 * <p>
 * 本题要求实现的是LRU cache，LRU的思想来自“最近用到的数据被重用的概率比最早用到的数据大的多”，是一种十分高效的cache。
 * <p>
 * 解决本题的方法是：双向链表+HashMap。
 * <p>
 *  注： HashMap O（1）大家都懂。
 * 对于双向链表的使用，基于两个考虑。
 * 首先，Cache中块的命中是随机的，和Load进来的顺序无关。
 * 其次，双向链表插入、删除很快，可以灵活的调整相互间的次序，时间复杂度为O(1)。
 * <p>
 * 新建数据类型Node节点，Key-Value值，并有指向前驱节点后后继节点的指针，构成双向链表的节点。
 *
 * <span style="font-size:18px;">class Node {
 * int key;
 * int value;
 * Node pre;
 * Node next;
 * public Node(int key, int value) {
 * this.key = key;
 * this.value = value;
 * }
 *
 * @Overri e    public String toString() {
 * return this.key + "-" + this.value + " ";
 * }
 * }</span>
 *
 *
 *
 * <span style="font-size:18px;">	int capacity;
 * HashMap<Integer, Node> map = new HashMap<Integer, Node>();
 * Node head = null;
 * Node end = null;
 * public LRUCacheTest(int capacity) {
 * this.capacity = capacity;
 * }</span>
 * <p>
 * <p>
 * “为了能够快速删除最久没有访问的数据项和插入最新的数据项，
 * 我们将双向链表连接Cache中的数据项，并且保证链表维持数据项从最近访问到最旧访问的顺序。 
 * <p>
 * 每次数据项被查询到时，都将此数据项移动到链表头部（O(1)的时间复杂度）
 * <p>
 * 这样，在进行过多次查找操作后，最近被使用过的内容就向链表的头移动，而没有被使用的内容就向链表的后面移动。
 * <p>
 * 当需要替换时，链表最后的位置就是最近最少被使用的数据项，我们只需要将最新的数据项放在链表头部，当Cache满时，淘汰链表最后的位置就是了。 ”
 * <p>
 * 解决了LRU的特性，现在考虑下算法的时间复杂度。为了能减少整个数据结构的时间复杂度，
 * 就要减少查找的时间复杂度，所以这里利用HashMap来做，这样时间复杂度就是O(1)。
 * <p>
 * 所以对于本题来说：
 * <p>
 * get(key): 如果cache中不存在要get的值，返回-1；如果cache中存在要找的值
 * ，返回其值并将其在原链表中删除，然后将其插入作为头结点。
 *
 *
 * <span style="font-size:18px;">	public int get(int key) {
 * if (map.containsKey(key)) {
 * Node n = map.get(key);
 * remove(n);
 * setHead(n);
 * printNodes("get");
 * return n.value;
 * }
 * printNodes("get");
 * return -1;
 * }</span>
 * <p>
 * <p>
 * set(key,value)：当set的key值已经存在，就更新其value，
 * 将其在原链表中删除，然后将其作为头结点；
 * 当set的key值不存在，就新建一个node，
 * 如果当前len<capacity,就将其加入hashmap中，
 * 并将其作为头结点，更新len长度，
 * 否则，删除链表最后一个node，再将其放入hashmap并作为头结点，但len不更新。
 *
 *
 * <span style="font-size:18px;">
 * public void set(int key, int value) {
 * if (map.containsKey(key)) {
 * Node old = map.get(key);
 * old.value = value;
 * remove(old);
 * setHead(old);
 * } else {
 * Node created = new Node(key, value);
 * if (map.size() >= capacity) {
 * map.remove(end.key);
 * remove(end);
 * setHead(created);
 * } else {
 * setHead(created);
 * }
 * map.put(key, created);
 * }
 * printNodes("set");
 * }</span>
 * <p>
 * <p>
 * 原则就是：每当访问链表时都更新链表节点。 
 * 最后附上完整源代码及输出结果如下：
 *
 * <span style="font-size:18px;">
 * import java.util.HashMap;import java.util.Hashtable;
 * * 权兴权意-2016.9.30 * 实现一个LRU Cache。要求查询和插入都在O(1) 时间内完成。双向链表+HashMap
 * public class LRUCacheTest {
 * <p>
 * int capacity;
 * <p>
 * HashMap<Integer, Node> map = new HashMap<Integer, Node>();
 * <p>
 * Node head = null;
 * <p>
 * Node end = null;
 * <p>
 * <p>
 * public LRUCacheTest(int capacity) {
 * this.capacity = capacity;
 * <p>
 * }
 * <p>
 * <p>
 * public int get(int key) {
 * if (map.containsKey(key)) {
 * Node n = map.get(key);
 * remove(n);
 * setHead(n);
 * printNodes("get");
 * return n.value;
 * }
 * printNodes("get");
 * return -1;
 * }
 * <p>
 * <p>
 * public void remove(Node n) {
 * if (n.pre != null) {
 * <p>
 * n.pre.next = n.next;
 * } else {
 * head = n.next;
 * }
 * if (n.next != null) {
 * n.next.pre = n.pre;
 * } else {
 * end = n.pre;
 * }
 * }
 * <p>
 * <p>
 * public void setHead(Node n) {
 * n.next = head;
 * n.pre = null;
 * if (head != null)
 * head.pre = n;
 * head = n;
 * if (end == null)
 * end = head;
 * }
 * <p>
 * <p>
 * public void set(int key, int value) {
 * if (map.containsKey(key)) {
 * Node old = map.get(key);
 * old.value = value;
 * remove(old);
 * setHead(old);
 * } else {
 * Node created = new Node(key, value);
 * if (map.size() >= capacity) {
 * map.remove(end.key);
 * remove(end);
 * setHead(created);
 * } else {
 * setHead(created);
 * }
 * map.put(key, created);
 * }
 * printNodes("set");
 * }
 * <p>
 * public void printNodes(String explain) {
 * System.out.print(explain + ":" + head.toString());
 * Node node = head.next;
 * while (node != null) {
 * System.out.print(node.toString());
 * node = node.next;
 * }
 * System.out.println();
 * }
 * <p>
 * <p>
 * public static void main(String[] args) {
 * LRUCacheTest lruCacheTest = new LRUCacheTest(5);
 * lruCacheTest.set(1, 1);
 * lruCacheTest.set(2, 2);
 * lruCacheTest.set(3, 3);
 * lruCacheTest.set(4, 4);
 * lruCacheTest.set(5, 5);
 * System.out.println("lruCacheTest.get(1):" + lruCacheTest.get(1));
 * lruCacheTest.set(6, 6);
 * System.out.println("lruCacheTest.get(2):" + lruCacheTest.get(2));
 * }
 * <p>
 * }
 * <p>
 * class Node {
 * <p>
 * int key;
 * <p>
 * int value;
 * <p>
 * Node pre;
 * <p>
 * Node next;
 * <p>
 * <p>
 * public Node(int key, int value) {
 * this.key = key;
 * this.value = value;
 * }
 * @Override public String toString() {
 * return this.key + "-" + this.value + " ";
 * }
 */


///*
//
//public class LRUCache {
//    int capacity;
//    int count;//cache size
//    Node head;
//    Node tail;
//    HashMap<Integer, Node> hm;
//
//    public LRUCache(int capacity) { //only initial 2 Node is enough, head/tail
//        this.capacity = capacity;
//        this.count = 2;
//        this.head = new Node(-1, -1, null, null);
//        this.tail = new Node(-2, -2, this.head, null);
//        this.head.next = this.tail;
//        hm = new HashMap<Integer, Node>();
//        hm.put(this.head.key, this.head);
//        hm.put(this.tail.key, this.tail);
//    }
//
//    public int get(int key) {
//        int value = -1;
//        if (hm.containsKey(key)) {
//            Node nd = hm.get(key);
//            value = nd.value;
//            detachNode(nd); //detach nd from current place
//            insertToHead(nd); //insert nd into head
//        }
//        return value;
//    }
//
//    public void put(int key, int value) {
//        if (hm.containsKey(key)) { //update
//            Node nd = hm.get(key);
//            nd.value = value;            //move to head
//            detachNode(nd); //detach nd from current place
//            insertToHead(nd); //insert nd into head
//        } else { //add
//            Node newNd = new Node(key, value, null, this.head);
//            this.head.pre = newNd; //insert into head
//            this.head = newNd;
//            hm.put(key, newNd); //add into hashMap
//            this.count++;
//            if (this.count > capacity) { //need delete node
//                removeNode();
//            }
//        }
//    }    //common func
//
//    public void insertToHead(Node nd) {
//        this.head.pre = nd;
//        nd.next = this.head;
//        nd.pre = null;
//        this.head = nd;
//    }
//
//    public void detachNode(Node nd) {
//        nd.pre.next = nd.next;
//        if (nd.next != null) {
//            nd.next.pre = nd.pre;
//        } else {
//            this.tail = nd.pre;
//        }
//    }
//
//    public void removeNode() { //remove from tail
//        int tailKey = this.tail.key;
//        this.tail = this.tail.pre;
//        this.tail.next = null;
//        hm.remove(tailKey);
//        this.count--;
//    }
//
//    public void printCache() {
//        System.out.println("\nPRINT CACHE ------ ");
//        System.out.println("count: " + count);
//        System.out.println("From head:");
//        Node p = this.head;
//        while (p != null) {
//            System.out.println("key: " + p.key + " value: " + p.value);
//            p = p.next;
//        }
//        System.out.println("From tail:");
//        p = this.tail;
//        while (p != null) {
//            System.out.println("key: " + p.key + " value: " + p.value);
//            p = p.pre;
//        }
//    }
//
//
//**/