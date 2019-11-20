package a014;

import java.util.HashSet;
import java.util.Set;

/**
 * 217.
 * Contains Duplicate
 * Difficulty
 * Easy

 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value
 * appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class containsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        //easy way , not good.....
//        Set<Integer>  set = new HashSet<>();
//        for(int i = 0; i < nums.length; i++){
//            if(set.add(nums[i])){
//                continue;
//            }else{
//                return true;
//            }
//        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(9^9^987);
    }
}
