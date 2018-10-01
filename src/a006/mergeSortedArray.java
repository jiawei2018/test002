package a006;

/**
 * 88. Merge Sorted Array
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */

public class mergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 题眼,一是从后往前!!!!!!!!!!!!!这个要一定记住,反向思维
        //题眼,因为nums1[]  自然在前面,所以就最后处理遗留问题是处理nums2[] 的    !!!!!!!!!!!
        if(m == 0 && n ==0) return;

        int i = m -1 , j = n - 1;
        int len = m + n - 1;

        while(  i >= 0 && j >=0){
            if(nums1[i] <= nums2[j]){
                nums1[len--] = nums2[j--];
            }else
                nums1[len--] = nums1[i--];
        }
        while(j >= 0)
            nums1[len--] = nums2[j--];//mistake
    }
}
