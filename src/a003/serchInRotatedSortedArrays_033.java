package a003;

/**
 * 33. Search in Rotated Sorted Array
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */

public class serchInRotatedSortedArrays_033 {
    //must !    time complexity o(logn)
    public int search(int[] nums, int target) {
        //这题一定要把图画出来然后分析3种情况

        //附加改造
        /**
         * 因为rotate的缘故，当我们切取一半的时候可能会出现误区，所以我们要做进一步的判断。具体来说，假设数组是A，每次左边缘为l，
         * 右边缘为r，还有中间位置是m。在每次迭代中，分三种情况：
         * （1）如果target==A[m]，那么m就是我们要的结果，直接返回；
         * （2）如果A[m]<A[r]，那么说明从m到r一定是有序的（没有受到rotate的影响），那么我们只需要判断target是不是在m到r之间，
         * 如果是则把左边缘移到m+1，否则就target在另一半，即把右边缘移到m-1。
         * （3）如果A[m]>=A[r]，那么说明从l到m一定是有序的，同样只需要判断target是否在这个范围内，相应的移动边缘即可。
         * 根据以上方法，每次我们都可以切掉一半的数据，所以算法的时间复杂度是O(logn)，空间复杂度是O(1)。
         */
        //if(nums.length <= 1 && target != nums[0] ) return -1; //这句leetcode过不去
//        if(nums.length == 0) return -1;
//
//        int left = 0;
//        int right = nums.length -1;
//        int mid ;
//        while(left <= right){//test at '<'
//            mid = (right + left) / 2;//我是猪啊,这个一定是a+b/2 不是a-b/2.....
//            if(nums[mid] == target) return mid;//关键的返回在这里
//            else if( nums[left] <= nums[mid] ){// nums[left] >= nums[right] 这句必须<=   否则过不了
//                if(target > nums[mid] || target < nums[left]){//这里用  && 更保险
//                    left = mid + 1;
//                }else
//                    right = mid - 1;
//            }else{//nums[left] > nums[mid]
//                if(target > nums[right] || target < nums[mid]){//在后面区间 must > right  or >= left
//                    right = mid - 1;//mistake 我把这个弄反了,就是区间搞错了,和下面的那句
//                }else
//                    left = mid + 1;//mistake 我把这个弄反了
//            }
//            //return mid; //这句是错误!!!
//        }
//        return -1;






//要用这个! && 版本的
        if(nums.length == 0) return -1;


        int left = 0;
        int right = nums.length -1;
        int mid ;
        while(left <= right){//test at '<'
            mid = (right + left) / 2;//我是猪啊,这个一定是a+b/2 不是a-b/2.....
            if(nums[mid] == target) return mid;//关键的返回在这里
            else if( nums[left] <= nums[mid] ){// nums[left] >= nums[right] 这句必须<=   否则过不了
                if(target < nums[mid] && target >= nums[left]){//must  选择  连续无间断区间
                    right = mid - 1;
                }else
                    left = mid + 1;
            }else{//nums[left] > nums[mid]
                if(target <= nums[right] && target > nums[mid]){//在后面区间 must > right  or >= left
                    left = mid + 1;//mistake 我把这个弄反了,就是区间搞错了,和下面的那句
                }else
                    right = mid - 1;//mistake 我把这个弄反了
            }
            //return mid; //这句是错误!!!
        }
        return -1;
    }











    public static void main(String[] args){

    }
}
