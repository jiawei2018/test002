package a004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class combinationSum_039 {
    //find all*     unique*

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>  res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        //res.contains();
        // sort first
        recur(candidates, target, res, temp, 0);
        return res;
    }

    private void recur(int[] nums, int target , List<List<Integer>> ans, List<Integer> temp , int curidx){
        if(target == 0 ){
            ans.add(new ArrayList<>(temp));//注意此处语法,means when temp changes after this one,
            // then there is a new() so a copy of the temp
            return;
        }
        for(int i = curidx; i < nums.length; i++){
            if(nums[i] > target){
                return;
            }
            temp.add(nums[i]);//今天头晕,需要多理解这句
            recur(nums, target - nums[i], ans, temp, i);//must be i not i+1 ,cause i+1 means no repitition
            temp.remove(temp.size() - 1);//今天头晕,需要多理解这句
            //这就是回溯的意思,去掉最后一位,把最后一个换成另一个,再回溯
            //https://www.youtube.com/watch?v=aBL-aNWNmB4
            //上面这个讲得比较清楚


        }
    }

    public static void main(String[] args){

    }

}
