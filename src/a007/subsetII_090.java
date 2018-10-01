package a007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class subsetII_090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //....居然一次就给ac了....吓死我了
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        recur(nums, res, temp, 0);
        return res;
    }

    private void recur(int[] nums, List<List<Integer>> res, List<Integer> temp, int idx){
        res.add(new ArrayList<>(temp));
        if(temp.size() == nums.length){
            return;
        }
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i - 1] == nums[i])
                continue;
            temp.add(nums[i]);
            recur(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
