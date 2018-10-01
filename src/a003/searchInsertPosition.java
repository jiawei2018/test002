package a003;

/**
 * 35. Search Insert Position
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */

//此题我的思路来自前边的两个binary search,
//如果没有找到目标元素，那么l一定停在恰好比目标大的index上，r一定停在恰好比目标小的index上，




//二分查找。如果判断过程中出现了nums[mid]==target，则直接返回索引mid；如果数组中没有target这个元素，
// 则在while循环后会出现low>high的情况，
// 而此时low正是target所应该放的位置，故返回low。
public class searchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 ) return 0;
        if(target < nums[0]) return 0;
        if(target > nums[nums.length - 1]) return nums.length;
        int res = 0;

        int left = 0;
        int right = nums.length - 1 ;

        while(left <= right){//must be <= or wrong
            int mid = (left + right) / 2;//  means left +(right - left)/2
            if(nums[mid] == target) return mid;

            if(target > nums[mid]){
                left = mid + 1 ;
            }else
                right = mid - 1 ;
        }

        return left;
    }

    public static void main(String[] args){
        //[1,3,5,6]
        //2

        int[] a1 = {1,3,5,6};
        int n = 2;
        searchInsertPosition t = new searchInsertPosition();
        t.searchInsert(a1,2);

    }
}
