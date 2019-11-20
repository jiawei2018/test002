import java.util.HashMap;
import java.util.Map;

public class LFU {
    public static void main(String[] args) {
        LFUCache tt = new LFUCache(2);
        //["LFUCache","put","put","get","put","get","get","put","get","get","get"]
        //[[2],      [1,1],[2,2],  [1], [3,3], [2],  [3], [4,4], [1],  [3],  [4]]
        tt.put(1,1);
        tt.put(2,2);
        tt.get(1);
        tt.put(3,3);
        tt.get(2);
        tt.get(3);
        tt.put(4,4);
        tt.get(1);
        tt.get(3);
        tt.get(4);

    }

    /*
    * freq 1    2   3   4   5   6   7
    *     dll  dll dll dll dll dll dll
    *
    *
    *
    *
    *
    *
    * */


    static class LFUCache {
        int cap;
        int size;
        int min;
        Map<Integer, Node> map;//   <key, node>
        Map<Integer, Dll> fmap;//freq map <freq, DLL>

        public LFUCache(int capacity) {
            map = new HashMap<>();
            fmap = new HashMap<>();
            cap = capacity;
        }

        public int get(int key) {
            Node cur = map.get(key);
            if(cur == null){
                return -1;
            }
            update(cur);
            return cur.val;
        }

        public void update(Node node){//update one node's freq
            //update used freq
            Dll cur = fmap.get(node.freq);
            cur.remove(node);//del from old-freq dll
            if(node.freq == min && cur.size == 0){//bug here is AND not or
                min++;
            }
            node.freq++;
            Dll dll = fmap.getOrDefault(node.freq, new Dll());
            dll.add(node);//add to new-freq dll
            fmap.put(node.freq, dll);
        }

        public void put(int key, int value) {//add or replace exist one <key,val1> -> <key, val2>
            if(cap == 0){// corner case
                return ;
            }

            if(map.containsKey(key)){
                Node cur = map.get(key);
                cur.val = value;
                update(cur);
            } else {
                Node node = new Node(key, value);
                map.put(key, node);//addfirst
                if(size == cap){
                    Dll mindll = fmap.get(min);
                    map.remove(mindll.delLast().key);
                    size--;
                }
                size++;

                //set min to 1 again
                min = 1;
                Dll dll = fmap.getOrDefault(node.freq, new Dll());
                dll.add(node);
                fmap.put(node.freq, dll);
            }
        }

        //first we need dll node
        class Node {
            int key;
            int val;
            int freq;
            Node prev;
            Node next;
            public Node(int k, int v){
                key = k;
                val = v;
                freq = 1;//init this new node
            }
        }

        //second we need doublely linked list
        class Dll{
            Node head;
            Node tail;
            int size;
            public Dll(){
                head = new Node(0, 0);//bug 1
                tail = new Node(0, 0);//bug 2
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            public void add(Node node){
                //add a node to head;
                Node tmp = head.next;
                head.next = node;
                node.next = tmp;
                tmp.prev = node;
                node.prev = head;
                size++;
            }

            public void remove(Node node){
                Node tmp = node.next;
                tmp.prev = node.prev;
                node.prev.next = tmp;
                size--;
            }

            public Node delLast(){//remove the least used
                if(size > 0){
                    Node cur = tail.prev;
                    remove(cur);
                    return cur;
                } else
                    return null;
            }

            public Node peekLast(){
                if(size > 0){
                    Node cur = tail.prev;
                    return cur;
                } else
                    return null;
            }
        }


    }
}
