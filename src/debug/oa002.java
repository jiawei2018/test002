package debug;

import java.util.*;

public class oa002 {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(30);
//        list.add(59);
//        list.add(110);
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        map.floorEntry(4).getValue();
//        System.out.println(2| false);
//        List li = new ArrayList<>();
//        byte a = 43;
//        byte d = 31;
    //    byte 4 = a + d;
       // double a = 123_123_.123;
        //System.out.println(maxProfit(1, 10, list));
    }
   // final string

    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
        // Write your code here
        //get the max cutlength
        int maxlen = 0;
        for(int i : lengths){
            maxlen = Math.max(maxlen, i);
        }
        int res = 0;
        Set<Integer> candi  = new HashSet<>();
        for(int p : lengths){
            //get all factors and we just use them to calculate
            candi.addAll(getf(p));
        }

        for(int i : candi){
            int sum = 0;
            for(int j : lengths){
                sum += getProfit(j, i, costPerCut, salePrice);
            }
            //can we o1? or ologn or
            res = Math.max(res, sum);
        }
        return res;
    }
    private static Set<Integer> getf(int k){
        int j = (int)Math.sqrt(k);
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i < j; i++){
            if(k % i == 0){
                set.add(i);
            }
        }
        return set;
    }


    private static int getProfit(int len, int cutlen, int cost, int price){
        if(len == cutlen){
            return len * price;
        }
        if(len < cutlen){
            return 0;
        } else {
            int part = len / cutlen;
            int cut = part;
            int single = (len - len % cutlen) / cut;
            if(len % cutlen == 0){
                cut--;
            }
            return single * part * price - cost * cut;
        }

    }
}
