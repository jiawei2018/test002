package a003;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

public class nextPermutation_030 {
    //* The replacement must be in-place and use only constant extra memory.

    public void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int idxl = 0,idxr = nums.length -1;
        //int tmp = 0;

        for(int i = nums.length-1; i > 0; i--){
            if(nums[i-1] < nums[i]){
                idxl = i-1;
               //  int tmp = nums[idxl];
                break;
            }
        }
        int mins = Integer.MAX_VALUE;
        for(int j = idxl; j < nums.length; j++){
            if(nums[j] > nums[idxl] && nums[j] <= mins){
                 mins =  nums[j];
                 idxr = j;
            }
        }

        swap(nums,idxl,idxr);
        System.out.println(idxl+"  <>  "+ idxr);
        Arrays.sort(nums,idxl + 1 , nums.length );//此处必须是nums.length  才是最后一位!!!!!


    }


    private void swap(int[] nums, int idxa, int idxb){
        int tmp = nums[idxa];
        nums[idxa] = nums[idxb];
        nums[idxb] = tmp;
    }

    public static void main(String[] args){

    }
}
