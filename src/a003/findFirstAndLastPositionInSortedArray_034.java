package a003;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class findFirstAndLastPositionInSortedArray_034 {
        // sorted
    //must : time complexity in log(n)
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int left = 0;
        int right = nums.length - 1;
        if(nums.length == 0) return res;
        if(target < nums[left] || target > nums[right]) return res;
        //本质是二分查找+ 中心扩散 罢了
        while(nums[left] != nums[right]){//此处必须是 !=   如果是 <= 则 会超时????为什么,
            // cause  that means left == right || right  = left + 1

            int mid = (left + right) / 2;

            if(target < nums[mid]) {
                right = mid -1;
            }else if(target >nums[mid]){
                left = mid +1;
            }else{//target = nums[mid]
                if(nums[left] < target ) left++;
                if(nums[right] > target) right--;
            }
        }

        if(nums[left] == target){
            res[0] = left;
            res[1] = right;
        }

        return res;
    }

    public static void main(String[] args){

    }
}
