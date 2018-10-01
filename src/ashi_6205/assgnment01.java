package ashi_6205;

public class assgnment01 {


    private int firstLargerSearch(int[] nums, int k, int left, int right) {

        if (right < left || k < nums[right])
            return -1;
        if (k < nums[left])
            return left;
        if (right == left && right + 1 < nums.length)
            return right + 1;
        int imid = (left + right) / 2 ;
            return firstLargerSearch(nums, k, imid , right);
   }



    }

