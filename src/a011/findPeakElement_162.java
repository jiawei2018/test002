package a011;

/**
 * 162. Find Peak Element
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 * Note:
 *
 * Your solution should be in logarithmic complexity.
 */
public class findPeakElement_162 {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        if(nums.length == 2){
            return nums[0] < nums[1] ? 1 : 0;
        }
        //题目中已经说明，最左端和最右端元素均无限小，中间元素比两侧都要大，
        // 那么本题中一定存在一个峰元素。所以不管中间有多少波峰，只要找到峰元素，
        // 我们只需找到刚刚开始下降而未下降的位置。//this is the key
        // 采用二分查找，查出这样一个位置即可，
        // 我们知道二分查找要比较的是 target 元素，
        // 本题的 target 元素是 mid 的后一个元素，
        // 即 nums[mid] 与 nums[mid+1] 进行比较：
        int left = 0;//不好理解
        //在解法二中，我们可以发现两个规律，一个是一定存在峰值元素，
        // 另一个是在遍历查找过程中对于某个元素之前的所有元素是递增的．
        // 其实这两个描述并不准确．我尝试用如下语句来描述这个规律：
        //
        //规律一：如果nums[i] > nums[i+1]，则在i之前一定存在峰值元素
        //规律二：如果nums[i] < nums[i+1]，则在i+1之后一定存在峰值元素
        //我们可以采用二分查找的方式设计如下算法：
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]){//就算mid是个peak,也不要!!!
                left = mid + 1;//现在,left左面已经比它小了,
            }else{//mid >= mid+1;
                right = mid;
            }

        }

        return left;
    }
}
