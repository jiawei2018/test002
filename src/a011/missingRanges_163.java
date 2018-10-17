package a011;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. Missing Ranges
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a sorted integer array nums,
 * where the range of elements are in the inclusive range [lower, upper],
 * return its missing ranges.
 *
 * Example:
 *
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */
public class missingRanges_163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(lower > upper || nums == null || nums.length == 0){
            res.add(makeword(lower, upper).toString());
            return res;
        }
        int idx;
        if(lower < nums[0]){
            res.add(makeword(lower, nums[0] - 1).toString());
        }
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1] && nums[i] < nums[i + 1] - 1){//!!!must be nums[i] != nums[i + 1] &&  if not
                //when nums[] == Integer.MIN_VALUE ,nums - 1 will be MAX_VALUE ...
                res.add(makeword(nums[i] + 1, nums[ i + 1] - 1).toString());
            }
        }
        if(nums[nums.length - 1] < upper){
            res.add(makeword(nums[nums.length - 1], upper).toString());
        }

        return res;
    }

    private StringBuilder makeword(int left, int right){
        StringBuilder sb = new StringBuilder();
        if(left == right){
            return sb.append(left);
        }
        sb.append(left + "->" + right);
        return sb;
    }
    //思路分析：这题基本就是考察双指针的应用，从lower-1开始，
    // 遍历nums数组找出missing range，
    // 可以利用pre和cur一前一后两个指针移动实现。
    // 注意lower和upper的处理，lower可以比nums中最小的数大，
    // upper可以比nums中最大的数小，所以考虑要周全。
    public List<String> findMissingRangesA(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int pre = lower - 1;
        int cur =  0;
        for(int i = 0; i < nums.length; i++){
            if(i == nums.length){
                cur = upper + 1;
            } else cur = nums[i];
            if(cur - pre >= 2){
                int missStart = pre + 1;
                int missEnd = cur - 1;
                if(missEnd == missStart) res.add(String.valueOf(missEnd));
                else res.add(missStart + "->" + missEnd);
                pre = cur;
            } else {
                pre = cur;
            }
        }
        return res;
    }



}
