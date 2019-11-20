package debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class allpermu_swapswap {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        allpermu_swapswap t = new allpermu_swapswap();
        System.out.println(t.getall(arr));
    }


    public List<String> getall(int[] nums){

        List<String> res = new ArrayList<>();
        recur(res, nums, 0);
        return res;
    }
    Random a = new Random();


    private void recur(List<String>  res, int[] nums, int idx){
        //base case
        //res.add(Arrays.toString(nums));
        if(idx == nums.length){
            res.add(Arrays.toString(nums));
            return ;
        }
        for(int i = idx; i < nums.length; i++){
            swap(nums, i, idx);
            recur(res, nums, idx + 1);
            swap(nums, i, idx);
        }


    }


    public static void swap(int[] nums, int idxa, int idxb){
        int tmp = nums[idxa];
        nums[idxa] = nums[idxb];
        nums[idxb] = tmp;
    }
}
