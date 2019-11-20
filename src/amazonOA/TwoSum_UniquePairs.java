package amazonOA;

import java.util.*;

public class TwoSum_UniquePairs {
    /*
    * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.

Example 1:

Input: nums = [1, 1, 2, 45, 46, 46], target = 47
Output: 2
Explanation:
1 + 46 = 47
2 + 45 = 47
Example 2:

Input: nums = [1, 1], target = 2
Output: 1
Explanation:
1 + 1 = 2
Example 3:

Input: nums = [1, 5, 1, 5], target = 6
Output: 1
Explanation:
[1, 5] and [5, 1] are considered the same.
Related problems:

https://leetcode.com/problems/two-sum
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
    * */
    //basic thoughts two pointers with dedup...

    // Java O(nlogn)
    public static int getUniquePairs(int[] nums, int target) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        int ans = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                ans++;
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
        return ans;
    }


    // java O(n)
    //thoughts
    // Wrong solution
    public static int getUniquePairsOpti(int[] nums, int target) {
        //Set<Integer> seen = new HashSet<>();
        Set<String> seen = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {

                 String key = map.get(num) + "," + num;
                //int key = map.get(num) * 10 + num;//this like a hash : idx * 10 + value
                //idx1: 1   val = 100 -> 110
                //idx2: 10  val = 10  -> 110
                //ca't use this hash function

                if (!seen.contains(key)) {
                    ans++;
                    seen.add(key);
                }
            } else {
                map.put(target - num, num);
            }
        }
        return ans;

    }


}
