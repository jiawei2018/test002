package a004;

/**
 * 55. Jump Game
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */

public class jumpGame_055 {
    //non-negative integers,
    //greedy
//思路:

    /**
     * [2,1,3,4,1,1,2]
     *  for reach st ,it cover idx 1 and 2; so it fit condition  i <= reach; i++
     * then go next
     * 关键是思路怎么来的?
     */
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) return true;
        int reach  = 0;
        for(int i = 0; i < nums.length && i <= reach; i++){//题眼   i即在数组范围内,又在之前的可到达范围内即 reach 范围内
            reach = Math.max(nums[i]+i, reach);//题眼
            if(reach >= nums.length - 1) return true;

        }


        return false;
    }

    private boolean canJumpA(int[] nums) {
        //this is greedy
        int size = nums.length;
        if(size <= 0){
            return false;
        }
        int maxJump = -1;//注意此处
        for(int i=0; i<size; i++){
            if(nums[i]>maxJump){
                maxJump=nums[i];
            }
            if(maxJump>=size-i-1){
                return true;
            }
            if(maxJump==0){
                return false;
            }
            maxJump--;//when i++ ,means maxjump--  这句很容易被 忽略掉导致错误
        }
        return false;
    }


}
