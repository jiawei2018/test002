package a12;

/**
 * 167. Two Sum II - Input array is sorted
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class twoSum_II_sortedArray {
    public static void main(String[] args) {
        int[] arr = {5,25,75};
        int ans = 100;
        twoSum_II_sortedArray t = new twoSum_II_sortedArray();
        t.twoSum(arr,100);

    }
    public int[] twoSum(int[] numbers, int target) {

        //还是练得少,吸收时候问题考虑不清楚.
        int[] res = new int[2];
        if(numbers == null || numbers.length == 0){
            return res;
        }
        //sorted binary search....
        int begidx = 1;
        int endidx = numbers.length - 1;
        for(int j = 0; j < numbers.length - 1; j++){
            if(j != 0 && numbers[j] == numbers[j - 1]){
                continue;
            }
               int cursub = target - numbers[j];
               int idxres = bs(numbers, j + 1, endidx, cursub);
               if(idxres != -1) {
                   res[0] = j + 1;
                   res[1] = idxres + 1;
                   return res;
               }
          }
        return res;
    }

    private int bs(int[] nums, int start, int end, int target){
        int left = start;
        int right = end;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }else
                left = mid + 1;
        }
        return  -1 ;
    }
}
