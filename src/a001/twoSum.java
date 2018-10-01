package a001;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *

 */

public class twoSum {

    public static void main(String[] args){

    }

    private int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> res = new HashMap<>();//<K,V>
        for(int i = 0 ; i < nums.length ; i++){
            int ans = target - nums[i];
            if(res.containsKey(ans)){
                int[] tmp= {res.get(ans),i};
                return tmp;
            }
            res.put(nums[i],i);
        }
        return null;
    }



































}
