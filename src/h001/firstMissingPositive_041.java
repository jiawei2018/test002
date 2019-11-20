package h001;

/**
 *  41. First Missing Positive
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 */

public class firstMissingPositive_041 {
    //unsorted
    // time o(n)
    //space o(1)
    public int firstMissingPositive(int[] nums) {//strange algorithm
        if(nums == null || nums.length == 0) return 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0){
                nums[i] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < nums.length; i++){
            int tmp = Math.abs(nums[i]);//must abs
            //System.out.println(nums[i]);
            if(tmp <= nums.length){//mistake <=  not <
                nums[tmp - 1] = -Math.abs(nums[tmp - 1]);//must abs
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
               return i + 1;
            }
        }
        return nums.length + 1;
    }



    public int firstMissingPositiveB(int[] nums) { //most popular algorithm...
        if(nums.length == 0)
            return 1;
        //第i位存放i+1的数值
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > 0){//nums[i]为正数，放在i+1位置
                //如果交换的数据还是大于0且<i+1，则放在合适的位置,且数据不相等，避免死循环
                //这个while是关键，其他都是没有难度的
                // while because when after one time swap ,
                //nums[nums[i]-1] is old nums[i]
                // nums[i] is old nums[nums[i]-1] ,but new nums[i] still dont know if it is in the right place....
                //then uxe while check
                  while(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] -1]){
                    int temp = nums[nums[i]-1];//交换数据
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        //循环寻找不符合要求的数据，返回
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        //如果都符合要求，则返回长度+1的值
        return nums.length + 1;
    }




//    private int generalWay(int[] nums){
//        //https://www.youtube.com/watch?v=8DqewGsVNkI    这个就是通用思维  ,这个还有 一个奇怪但是可行解法
//        boolean[] ck= new boolean[Integer.MAX_VALUE];//建立全部正整数的数组
//
//        for(int i = 0; i < nums.length; i++){//遍历一次 ,跳过所有的负数和0,
//            if(nums[i] <= 0) continue;
//
//            ck[nums[i]] = true;//找到boolean数组idx = nums[i] 的 设置成 true;
//
//        }
//        int ans  = 1;
//        for(int j = 0; j < Integer.MAX_VALUE; j++){//遍历第二遍 找到第一个是false的idx,则 ans就是 idx+1
//            if(ck[j] == false) ans = j+1;
//        }
//
//        return ans;
//    }

    public static void main(String[ ] args){

    }
}
