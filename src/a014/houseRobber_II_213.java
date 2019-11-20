package a014;

/**
 * 213.
 * House Robber II
 * Difficulty
 * Medium
 * <p>
 * Submissions
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile,
 * adjacent houses have security system connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 * because they are adjacent houses.
 * Example 2:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class houseRobber_II_213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //only happens if length is odd number. but 1 will not be in it
        return Math.max(
                maxrob(nums, 0, nums.length - 2)
                ,
                maxrob(nums, 1, nums.length - 1)
               );
    }

    private int maxrob(int[] nums, int startidx, int endidx) {
        if (endidx - startidx + 1 == 2) {
            return Math.max(nums[startidx], nums[endidx]);
        }
        int[] dp = new int[endidx - startidx + 1];
        dp[0] = nums[startidx];
        dp[1] = Math.max(nums[startidx], nums[startidx + 1]);//我是猪,尼玛,我自己写的都不记得了,
        //dp[1] 是一个动态最大值,就是到1 位置 最大可能值
        for (int i = 2; i < dp.length; i++) {
            //System.out.println(i);
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[startidx + i]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1,  };
        houseRobber_II_213 t = new houseRobber_II_213();
        System.out.println(t.rob(arr));

    }
}
