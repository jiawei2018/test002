package other_oa;

import java.time.Instant;
import java.util.*;

public class hashtable_oa_example {
    public static void main(String[] args) {
        String t = "opop|oop|;l;";
        String t1 = "1563454984001|INSERT|test|123";
        String t2 = "1563454984002|INSERT|test|211";
        String t3 = "1563454984003|INSERT|test|212";

        /*
        * 1563454984001|INSERT|test|123
1563454984002|INSERT|test|321
        *
        * */


        String[] h = t.split("\\|");

        System.out.println(Arrays.toString(h));

    }
    public static class HashTable {
        Map<String, String> map;
        TreeMap<Instant, Event> treemap;
        List<Event> elist;

        public HashTable(ArrayList<String> rawEvents) {
            // TODO
            //corner case
            if(rawEvents == null || rawEvents.size() == 0){
                return;
            }
            map = new HashMap<>();
            //latest = new Event();
            treemap = new TreeMap<>((a, b) -> (a.compareTo(b)));
            elist = new ArrayList<>();//we need to sorted the input first since we need to makesure time-line
            for(String str : rawEvents){
                Event e = convert(str);
                if(e != null){
                    elist.add(e);
                }
            }
            Collections.sort(elist, (e1, e2) ->{
                return e1.time.compareTo(e2.time);
            });
            for(Event is : elist){
                if(is.type.equals("INSERT")){
                    insert(is);
                } else if(is.type.equals("UPSERTT")){
                    upsert(is);
                } else {//"DELETE"
                    delete(is);
                }
                //need to chk
                //latest = is;
            }

        }


        private Event convert(String str){
            String[] tmp = str.split("|");
            if(tmp.length != 4 ){
                return null;//invalid input data
            }
            Event e = new Event();
            e.time = Instant.ofEpochMilli(Long.valueOf(tmp[0]));
            e.type = tmp[1];
            e.key = tmp[2];
            e.value = tmp[3];
            return e;
        }

        /**
         * Retrieve the state of the HashTable after applying all input events
         *
         * @return a Map representing the Keys and Values of the current state
         */
        public Map<String, String> getTable() {
            return map;  // TODO
        }
        // can we use treeset?

        private boolean insert(Event is){
            //sucessful insert will return true;
            if(!map.containsKey(is.key)){
                map.put(is.key, is.value);
                treemap.put(is.time, is);
                return true;
            }
            treemap.put(is.time, is);
            return false;
        }

        private boolean delete(Event is){
            //sucessful delete will return true;
            if(map.containsKey(is.key)){
               map.remove(is.key);
               treemap.remove(is.time);
               return true;
            }
            return false;
        }

        private void upsert(Event is){
            if(map.containsKey(is.key)){
                map.remove(is.key);
                treemap.remove(is.time);
            }
            treemap.put(is.time, is);
            map.put(is.key, is.value);
        }

        /**
         * Retrieve the high-watermark of the HashTable as the millisecond epoch timestamp
         * of the latest event read or Instant.EPOCH in the case where no event occurred.
         *
         * @return an Instant representing the high watermark
         */
        //Instant latest;
        public Instant getHighWatermark() {// ? what is "Instant" ?
            if(treemap.isEmpty()){
                return Instant.EPOCH;
            }

            return treemap.lastEntry().getKey();  // TODO
        }


        class Event{
            Instant time;
            String type;
            String key;
            String value;
            public Event(){

            }
            public Event(Instant t, String tp, String k, String v){
                time = t;
                type = tp;
                key = k;
                value = v;
            }
//            @Override
//            public String toString(){
//                return time + "|" + type+ "|" +key+ "|" +value;
//            }
        }


        /*
        time|type|K|V
        time is a long int, type is only 3, KV
        insert like add,when there is entry exsits do nothing, return false;
        upsert 1.exist  ->delete->  insert
                2. not exist -> insert
        delete like remove,


        */
    }
}
