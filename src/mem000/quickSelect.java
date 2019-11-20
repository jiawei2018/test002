package mem000;

public class quickSelect {
    private int helper(int[] nums, int k, int left, int right){
        return 0;
    }

    private int partition(int[] nums, int start, int end ){
        int pivot = nums[end];
        int left = start;
         int right = end;
         while(left <= right){

             if(nums[left] < pivot){
                 left++;
             } else if(nums[right] >= pivot){
                 right--;
             } else {
                 swap(nums, left++, right--);
             }
         }

         swap(nums, left, pivot);
         return left;//return the right idx for pivot
    }


    private void swap(int[] nums , int idxa, int idxb){
        int temp = nums[idxa];
        nums[idxa] = nums[idxb];
        nums[idxb] = temp;
    }

}
