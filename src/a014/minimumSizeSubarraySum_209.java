package a014;

/**
 * 209.
 * Minimum Size Subarray Sum
 * Difficulty
 * Medium
 * <p>
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution,
 * try coding another solution of which the time complexity is O(n log n).
 */
public class minimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int leftidx = 0;
        int rightidx = 0;
        int minsum = Integer.MAX_VALUE;
        int sum = 0;
        while (rightidx < nums.length) {

            while (rightidx < nums.length && sum < s) {
                sum += nums[rightidx++];
            }

            while (leftidx <= rightidx && sum >= s) {//make sure sum >= s give minsum valid value
                sum -= nums[leftidx++];
                minsum = Math.min(minsum, rightidx - leftidx + 1);//must in while loop ,so there is an answer
            }

            //mistake think  2,3 ;right -left = 1 but there are two numbers
        }


        return minsum == Integer.MAX_VALUE ? 0 : minsum;
    }



    //method two ......from csdn
    public int minSubArrayLenA(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] sums = new int[len];
        sums[0] = nums[0];

        for (int i = 1; i < len; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        int res = len + 1;

        for (int i = 0; i < len; i++) {
            int end = helper(i, sums, s);
            res = Math.min(res, end - i + 1);
        }
        return res == len + 1 ? 0 : res;
    }


    private int helper(int idx, int[] sums, int target) {
        // search sums[i]  to sums[end];
        //sums[mid] - sums[start];
        int left = idx, right = sums.length - 1;
        int offset = idx == 0 ? 0 : sums[idx - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //sums[mid] - sums[start];
            int sum = sums[mid] - offset;

            //if find one,then try to find smaller one
            if (sum >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
