package googleOA;

public class LargestSubarrayLengthK {
    /*
    *bf get all size = k subarray and sort base on first differetn char;
    *
    *
    * */

    public int[] LargestSubarrayLengthK(int[] nums, int k){
        if(nums.length < k){
            return nums;
        }
        int start = 0;
        for(int i = 0; i < nums.length - k; i++){
            for(int j = 0; j <= k; j++){
                if(nums[i + j] > nums[start + j]){
                    start = i;
                    break;
                }
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = nums[start + i];
        }
        return res;
    }
}
