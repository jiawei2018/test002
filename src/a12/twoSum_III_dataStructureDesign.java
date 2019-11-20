package a12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 170. Two Sum III - Data structure design
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * Example 1:
 *
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * Example 2:
 *
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 */
public class twoSum_III_dataStructureDesign {
    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        t.add(1);
        t.add(2);
        t.add(3);
        //t.add(7);
       // t.add(9);
        t.find(6);

    }
    static class TwoSum {

        /** Initialize your data structure here. */
        public TwoSum() {

        }

        /** Add the number to an internal data structure.. */

        Map<Integer, Integer> map = new HashMap<>();
        //自己还差得远/......
        public void add(int number) {
            if(map.containsKey(number)) {
                map.put(number, map.get(number) + 1);//重复元素
            } else {
                map.put(number, 1);
            }
        }

        public boolean find(int value) {
            for(int key : map.keySet()) {
                int target = value - key;//
                if(target == key && map.get(key) > 1) {
                    return true;
                } else if(target != key && map.containsKey(target)) {
                    return true;
                }
            }
            return false;
        }


    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
}
