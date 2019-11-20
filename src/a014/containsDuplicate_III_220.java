package a014;

import java.util.*;

/**
 * 220.
 * Contains Duplicate III
 * Difficulty
 * Medium

 * Given an array of integers,
 * find out whether there are
 * two distinct indices i and j in the array such that
 * the absolute difference between nums[i] and nums[j] is at most t
 * and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class containsDuplicate_III_220 {
    /**
     *
     * 非常重要的技巧和treeset的首次应用!!!!!!!
     *
     *
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */





    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //nums[i] - nums[k] < t
        //i - j < k
        // add a map? <idxs idxl>
        if(nums == null || nums.length < 2 || k < 1 || t < 0){//mistake here
            return false;
        }
        SortedSet<Long> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){
            //	subSet(E fromElement, E toElement)
            //Returns a view of the portion of this set
            // whose elements range from fromElement, inclusive!!!, to toElement, exclusive!!!!!!.
            // means    a <=  nums[eles] < b
            SortedSet<Long> subSet = set.subSet((long)nums[i] - t, (long)nums[i] + t + 1);

            if(!subSet.isEmpty()){
                return true;
            }

            //if the range is > |i - j| , rempve the leftside ele
            if(i >= k){
                set.remove((long)nums[i - k]);
            }
            set.add((long)nums[i]);//add new  ele, after del old ones.

        }
        return false;

    }

    private int[] inthet(int[] nums, int idx, int k, int t){
        int[] res = new int[2];
        Map<Integer ,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

        }

        return res;
    }
}
