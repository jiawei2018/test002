package a006;

/**
 * 75. Sort Colors
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class sortColours_075 {
    public void sortColors(int[] nums) {
        if(nums.length <= 1 || nums == null){
            return;
        }
        int j = nums.length -1;
        int left = 0;
        for(int i = 0; i <= j; i++){
            if(nums[i] == 0){
                swap(nums, i,left++);
            }

            if(nums[i] == 2){
                swap(nums, i, j);
                j--;
                i--;
            }
        }
    }

     private void swap(int[] nums,int idxa , int idxb){
         int tmp = nums[idxa];
         nums[idxa] = nums[idxb];
         nums[idxb] = tmp;
     }

    public static  void main(String[] args){
        sortColours_075 t = new sortColours_075();

        //int[] in = {2,0,1,1,1,0};
        int[] in = {2,0,1};
        t.sortColors(in);
        for(int i = 0; i < in.length; i++) System.out.println(in[i]);
       // System.out.println(in);
    }
}


/**tI太夸张了,学会,举一反三!!!
 * void sortColors(int A[], int n) {
 *         int i = -1;
 *         int j = -1;
 *         int k = -1;
 *         for(int p = 0; p < n; p ++)
 *         {
 *             //根据第i个数字，挪动0~i-1串。
 *             if(A[p] == 0)
 *             {
 *                 A[++k] = 2;    //2往后挪
 *                 A[++j] = 1;    //1往后挪
 *                 A[++i] = 0;    //0往后挪
 *             }
 *             else if(A[p] == 1)
 *             {
 *                 A[++k] = 2;
 *                 A[++j] = 1;
 *             }
 *             else
 *                 A[++k] = 2;
 *         }
 *
 *     }
 */
