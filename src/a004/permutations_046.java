package a004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class permutations_046 {

    //本题就是照搬的hauhua的那个排列组合的recursion的原理而已.

    /** 附程序
     * 组合
     * P(int nums[], int depth, int n, list<> curr, List<List<>  ans, boolean[] used){
     *      if d == n:
     *           ans.append(curr)
     *            return
     *
     *     for i = 0 to len(nums):
     *      if used[i]:continue
     *      used[i] = true
     *      curr.push(nums[i])
     *      P(nums, depth + 1, n, curr, ans, used)
     *      curr.pop()
     *      used[i] = false
     *
     *
     * }
     *
     *
     */




    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);//nessicery
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> tmp  = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        recur(nums,res,tmp,0,used);
        return res;
    }

    private void recur(int[] nums, List<List<Integer>> res, List<Integer> tmp, int idx, boolean[] used){
        if(tmp.size() == nums.length){//退出条件的不同,要理解融会贯通,
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] == true){
                continue;
            }
            used[i] = true;
            tmp.add(nums[i]);
            recur(nums,res,tmp,idx +1,used);
            tmp.remove(tmp.size()-1);
            used[i] = false;
        }

    }



}
