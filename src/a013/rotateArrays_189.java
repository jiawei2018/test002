package a013;

/**
 * 189.
 * Rotate Array
 * Difficulty
 * Easy

 * Given an array, rotate the array to the right by k steps,
 * where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can,
 * there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class rotateArrays_189 {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int tmp =  k % nums.length;//注意这个地方,首先是不能直接用k的,第二要考虑
        //大于长度的问题,这个题的题眼一定是边界条件
        reverese(nums, 0, nums.length - 1);//先反转
        reverese(nums, 0 , tmp - 1);//idx start from 0,so tmp - 1
        reverese(nums, tmp  , nums.length - 1);
    }
    private void reverese(int[] nums, int left, int right){
       while(left <= right){
           swap(nums, left++, right--);
       }
    }
    private void swap(int[] nums, int idxa, int idxb){
        int i = nums[idxa];
        nums[idxa] = nums[idxb];
        nums[idxb] = i;
    }

}
