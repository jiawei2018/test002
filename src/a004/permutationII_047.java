package a004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */

public class permutationII_047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> tmp  = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        recur(nums,res,tmp,used);
        return res;
    }

    private void recur(int[] nums, List<List<Integer>> res, List<Integer> tmp,  boolean[] used){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if( i > 0 && used[i - 1] && (nums[i] == nums[i-1])){//题眼,
                // 此处的 used[i - 1] == true  表示 ,即上一个 即用过了,当前这个和上一个还一样
                continue;
            }
            if(used[i] == true  ){
                continue;
            }
            used[i] = true;
            tmp.add(nums[i]);
            recur(nums,res,tmp,used);
            tmp.remove(tmp.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args){
        permutationII_047 t = new permutationII_047();
        int[]  n = {1,1,2};

        System.out.println(t.permuteUnique(n));

    }

}
