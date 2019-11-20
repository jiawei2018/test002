package a014;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 215.
 * Kth Largest Element in an Array
 * Difficulty
 * Medium

 * Submissions
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class kthLargestElementsInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
            //quick select?
        if(nums.length == 0 ){
            return 0;
        }

        quickSelect(nums, 0, nums.length - 1, k);

        return nums[k];

    }

    private void quickSelect(int[] nums, int left, int right, int target){
        int mid = partition(nums,left, right);

        if(mid == target){
            return;
        }else if(mid < target){
            quickSelect(nums, mid, right,target);
        }else{
            quickSelect(nums, left, mid, target);
        }

    }

    private int partition(int[] nums, int left, int right){
        //
        int pivot = nums[right];
        int start = left;
        int end = right -1;
        while(start <= end){//mistake ,, must make sure stop only when start - 1 = end ,they acrossed
            if(nums[start] < pivot){
                start++;
            }else if(nums[end] >= pivot){//mis take
                end--;
            }else{
                swap(nums, start++, end--);
            }
        }
        swap(nums, start, right);
        return start;
    }



    private void swap(int[] nums, int idxa, int idxb){
        int temp = nums[idxa];
        nums[idxa] = nums[idxb];
        nums[idxb] = temp;
    }


    //use heap
    public int findKthLargestA(int[] nums, int k) {
        if(nums.length == 0 ){
            return 0;
        }

        PriorityQueue<Integer> minheap =  new PriorityQueue<>();//natural is minheap
        //max heap use PriorityQueue<>(Collections.reverseOrder())
        for(int i = 0; i < nums.length; i++){
            if(i < k){
                minheap.offer(nums[i]);
            }else if(nums[i] > minheap.peek()){
                minheap.offer(nums[i]);
                minheap.poll();
            }
        }
        return minheap.peek();
    }

}
