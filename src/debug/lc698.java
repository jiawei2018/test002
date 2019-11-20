package debug;

import java.util.ArrayList;
import java.util.List;

public class lc698 {
    public static void main(String[] args) {
        /*
        * [129,17,74,57,1421,99,92,285,1276,218,1588,215,369,117,153,22]
                3
        * */

        int[] arr = {129,17,74,57,1421,99,92,285,1276,218,1588,215,369,117,153,22};

        lc698 t = new lc698();
        System.out.println(t.canPartitionKSubsets(arr, 3));
        System.out.println(t.rp);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null){
            return false;
        }
        List<Integer> ipt = new ArrayList<>();
        int sum = 0;
        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];
            //ipt.add(nums[i]);
        }

        int target = sum / k;
        if(target * k != sum){
            return false;
        }
        return recur(nums, new boolean[nums.length],0, target, 0);

    }
    int rp = 0;
    private boolean recur(int[] nums, boolean[] visited, int sum, int target, int idx){
        rp++;
        //System.out.println(input);
        // System.out.println(" +  " + sum);
        if( idx == nums.length && sum == 0){
            return true;
        }
        for(int i = idx; i < nums.length; i++){
            if(visited[i] || sum + nums[i] > target ){
                continue;
            }
            visited[i] = true;
            if(sum + nums[i] == target){
                if(recur(nums, visited, 0, target, i + 1)){
                    return true;
                }
            } else {
                if(recur(nums, visited, sum + nums[i], target, i + 1)){
                    return true;
                }
            }
            visited[i] = false;
        }

        return false;
    }
}
