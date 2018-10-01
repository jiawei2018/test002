package a006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. Subsets
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class subsets_078 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        //res.add(tmp);
        Arrays.sort(nums);
        if(nums.length == 0 ) return res;

        //此题 题设已经给出了  "distinct integers"  怪自己读题不好


        //取消下面这堆 判断就能过......为什么?  case: input ==  {0}
//        if(nums.length == 1){
//            res.add(tmp);
//            tmp.add(nums[0]);
//            res.add(tmp);
//            return res;
//        }

            recur(res, tmp, 0, nums);


        return res;

    }

    private void recur(List<List<Integer>> res, List<Integer> tmp, int idx,int[] nums){

            res.add(new ArrayList<>(tmp));//这个点 很容易被忘掉!!!!!!!!!!!!!!!!!!!!!!!!!!!
           // return;

        for(int i = idx; i < nums.length; i ++){//这里是个点,  起点一定是idx, 而不是 0 !!!!!!!!!不重复元素
            if( i > idx  && nums[i] == nums[i - 1]) continue;
            tmp.add(nums[i]);
            recur(res, tmp, i + 1, nums );
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args){
        subsets_078 t = new subsets_078();
        int[] ins = {1,2,3};
        System.out.println(t.subsets(ins));
    }
}
