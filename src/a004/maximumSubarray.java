package a004;

/**
 * 53. Maximum Subarray
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class maximumSubarray {

    public int maxSubArray(int[] nums) {
        //dp   很难想到的方法............
        if(nums.length == 0 || nums == null) return 0;
        int maxsum = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];

            maxsum = Math.max(sum, maxsum);

            sum = Math.max(sum,0);

        }
        return 0;
    }

    private int mrthod02(int[] nums){
        //这道题就是难理解
        //这个想法还是比较好的
        //from bassket wang
        //还是dp
        int maxcurr = nums[0];
        int maxsum = nums[0];

        for(int i = 0; i < nums.length; i++){
            maxcurr = Math.max(maxcurr + nums[i], nums[i]);//这个是题点,总结想到的,如何  "抛弃" 才是思路的核心
            maxsum = Math.max(maxsum, maxcurr);
        }
        return maxsum;
    }
}
