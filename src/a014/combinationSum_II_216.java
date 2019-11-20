package a014;

import java.util.ArrayList;
import java.util.List;

/**
 * 216.
 * Combination Sum III
 * Difficulty
 * Medium

 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9
 * can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class combinationSum_II_216 {
    public static void main(String[] args) {
        combinationSum_II_216 t = new combinationSum_II_216();
        //System.out.println(t.combinationSum3(3,37));
        System.out.println(t.combinationSum3(4,37).size());


    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(k <= 0 || n <= 0){
            return res;
        }
        recur(res, temp, 1, 0, n, k, k);
        return res;
    }

    private void recur(List<List<Integer>> res, List<Integer> temp, int level, int sum, int target, int remain, int k){
        if(sum == target && remain == 0 ){
            res.add(new ArrayList<>(temp));
            return;
        }else if(sum > target || 0 == remain){
            return;
        }
        for(int i = level; i <= target; i++ ){//leet code bug!!! must be target not 9!!!!
            temp.add(i);
            //System.out.println(temp);
            recur(res, temp, i + 1, sum + i , target, remain - 1, k);
            temp.remove(temp.size() - 1);
        }

    }
        ///why why why????????????????
    public List<List<Integer>> combinationSum31(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if(k<1 || n<1 || k>n) return result;
        dfs(result, cur, 0, k, n, 1);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> cur, int sum, int k, int n, int level) {
        if(sum == n && k==0) {
            result.add(new ArrayList(cur));
            return;
        } else if(sum> n || k<0) return;
        for(int i=level;i<=9;i++){//
            cur.add(i);
            dfs(result, cur, sum+i, k-1, n, i+1);
            cur.remove(cur.size()-1);
        }
    }





}
