package a004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */

public class combinationSumII_040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            ans.add(new ArrayList<>(temp));//注意此处语法
            return;
        }
        for(int i = curidx; i < nums.length  ; i++){
            if(nums[i] > target){
                return;
            }
            if(i != curidx && nums[i] == nums[i - 1]){//这里是题眼
                //这里去重是去掉重复的答案,意思是,1-2-2`-3-4...
                //如果 1-2-分支有了,则显然,1-2`的分支是答案相同的

                //ex 1,1,2,5,6,7,10
                //这里的重点是去重，重复的是当前position的位置与下一个position位置，而不是在当前position位置后遍历重复的数字

                //关键在于这部防止重复，规则就是排序后，如果当前位置i的数字和i-1的一样，
                // 那么必须要i用过后，i-1才能用，不然必须跳过，所有都是
                //这就是回溯的意思,去掉最后一位,把最后一个换成另一个,再回溯
                //https://www.youtube.com/watch?v=aBL-aNWNmB4
                //上面这个讲得比较清楚
                continue;
            }
            temp.add(nums[i]);//今天头晕,需要多理解这句
            recur(nums, target - nums[i], ans, temp, i + 1);//还有这里的 i + 1 也是题眼

            temp.remove(temp.size() - 1);//今天头晕,需要多理解这句
        }

    }
}
