package a12;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 179.
 * Largest Number

 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class largestNumber_179 {

    public static void main(String[] args) {
        int[] a = {3,30,34,5,9};
        largestNumber_179 t = new largestNumber_179();
        System.out.println(t.largestNumber(a));

    }
    public String largestNumber(int[] nums) {
        //知识点1, array.sort 方法如何传 comparetor
        //知识点2 , string比较,用 .compareTo 方法
        if(nums == null || nums.length < 1){
            return null;
        }
         String[] str = new String[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, new mySort());
        StringBuilder sb = new StringBuilder();

        if(str[0].equals("0")){//this coner case is easy to forget
            return "0";
        }

        for(int i = 0; i < str.length; i++){
            sb.append(str[i]);
        }

        return sb.toString();

    }

    class mySort implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {// isimportant to familar with this way!!!!
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            if(s1.compareTo(s2) < 0 ){
                return  1;
            }else if(s1.compareTo(s2) > 0){
                return -1;
            }else
                return 0;
        }
    }

}
