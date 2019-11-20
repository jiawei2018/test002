package dataStructure;

import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapTest {
    public void test(){
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.ceilingKey(1);
        tm.floorKey(2);
        tm.ceilingEntry(1);
        tm.floorEntry(3);

    }

    public void testSet(){
        TreeSet<Integer> set = new TreeSet<>();

    }

    public static String sum(String s1, String s2){
        StringBuilder res = new StringBuilder();
        int end1 = s1.length() - 1;
        int end2 = s2.length() - 1;
        int sign1 = s1.charAt(0) == '-' ? -1 : 1;
        int sign2 = s2.charAt(0) == '-' ? -1 : 1;

        int carry = 0;
        while(end1 >= 0 || end2 >= 0){
            int i1 = 0;
            int  i2 = 0;
            if(end1 >= 0){
                i1 = s1.charAt(end1--) - '0';
            }
            if(end2 >= 0){
                i2 = s2.charAt(end2--) - '0';
            }
            int sum = carry + i1 + i2;
            if(sum > 9){
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            res.insert(0, Math.abs(sum));

        }
        if(carry == 1){
            res.insert(0, 1);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s1 =    "99";
        String s2 =   "99";
        System.out.println(sum(s1, s2));
    }
}
