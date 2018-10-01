package a006;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */

public class COMBINATIONS_077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if(n == 0 ) return res;
        if(n == 1){
            tmp.add(1);
            res.add(tmp);
            return res;
        }
        int[] nums  = new int[n];
        //boolean[] used = new boolean[n];
        for(int i = 0; i < n; i++ ){
            nums[i] = i + 1;
           // System.out.println(nums[i]);
        }
        recur(res, tmp, 0, nums,  k);
        return res;

    }

    private void recur(List<List<Integer>> res, List<Integer> tmp, int idx,int[] nums, int k){
        if(tmp.size() == k){
            res.add(new ArrayList<>(tmp));//这个点 很容易被忘掉!!!!!!!!!!!!!!!!!!!!!!!!!!!
            return;
        }
        for(int i = idx; i < nums.length; i ++){//这里是个点,  起点一定是idx, 而不是 0 !!!!!!!!!不重复元素
            //if(used[i])
            //    continue;

           // used[i] = true;
            tmp.add(nums[i]);
            //System.out.println(tmp.toString() + "    <<<");
            recur(res, tmp, i + 1, nums,   k);
            tmp.remove(tmp.size() - 1);
           // used[i] = false;
        }
    }

    public static void main(String[] args){
        COMBINATIONS_077 t = new COMBINATIONS_077();
        System.out.println(t.combine(2,2).toString());
    }
}
